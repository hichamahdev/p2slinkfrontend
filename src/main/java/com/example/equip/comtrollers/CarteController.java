package com.example.equip.comtrollers;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.equip.exception.RessourceNotFoundException;
import com.example.equip.model.Carte;
import com.example.equip.model.Equipement;
import com.example.equip.model.Port;
import com.example.equip.model.Slot;
import com.example.equip.repository.CarteRepository;
import com.example.equip.repository.PortRepository;
import com.fasterxml.jackson.annotation.OptBoolean;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")

public class CarteController {

	@Autowired
	private CarteRepository carteRepository;
	
	@Autowired
	private PortRepository portRepository ;
	
	@GetMapping("/carte")
	public List<Carte> getAllCartes() {
		
	    return carteRepository.findAll();
	}

	@GetMapping("/carte/{id}")
	public ResponseEntity<Carte> getCarteById(@PathVariable Long id) {
	   
		Carte carte = carteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		return ResponseEntity.ok(carte);
			
	}
	
	@GetMapping("/carte/{id}/port")
	public List<Port> GetPortByCarte(@PathVariable Long id) {
	    Optional<Carte> carte = carteRepository.findById(id);	
	    List<Port> ports = new ArrayList<Port>();
	    List<Port> portsCon = new ArrayList<Port>();
	    if(carte.isPresent()) {
	    	
		ports= carte.get().getPort();
		for(int i=0;i<ports.size();i++) {
			if(ports.get(i).isConnecte()) {
				portsCon.add(ports.get(i));
			}
		}
		
		return portsCon;
	    }		
	    return null;
	}
	
	@PostMapping("/carte")
	public Carte AddCarte(@RequestBody Carte carte) {
		
		List<Port> port = carte.getPort();
		port = new ArrayList<Port>(carte.getNumberPort());
		
		for(int i=0; i<carte.getNumberPort() ; i++) {
			Port portt = new Port();
			
			portt.setNomPort("P"+(i+1));			
			
			
			portRepository.save(portt);
			port.add(portt);
			
		}
		
		carte.setPort(port);
		
	    return carteRepository.save(carte);
	}
	
	@PutMapping("/carte/{id}")
	public ResponseEntity<Carte> updatePort(@PathVariable Long id , @RequestBody Carte carteDetails){
		Carte carte = carteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
	
		carte.setNomCarte(carteDetails.getNomCarte());
		carte.setTypeCarte(carteDetails.getTypeCarte());
		
		carte.setPort(carteDetails.getPort());
		
		
		Carte updatedCarte = carteRepository.save(carte);
		
		return ResponseEntity.ok(updatedCarte);
	}
	
	@DeleteMapping("/carte/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCarte(@PathVariable Long id){
		Carte carte = carteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		carteRepository.delete(carte);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/carte/slot")
	public List<Carte> getAllEquipementwithoutsite() {
		
	    return carteRepository.findCarteWithoutSlot();
	}
		
}

package com.example.equip.comtrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.example.equip.model.Attribut;

import com.example.equip.repository.AttributsRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AttributController {
	
	@Autowired
	private AttributsRepository attributsRepository;
	
	@GetMapping("/attribut")
	public List<Attribut> getAllAttributs() {
		
	    return attributsRepository.findAll();
	}

	@GetMapping("/attribut/{id}")
	public ResponseEntity<Attribut> getAttributsById(@PathVariable Long id) {
	   
		Attribut attribut = attributsRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("attribut not exist with id:" + id));
		return ResponseEntity.ok(attribut);
	}
	
	@PostMapping("/attribut")
	public Attribut AddAttribut(@RequestBody Attribut attribut) {
	    return attributsRepository.save(attribut);
	}
	
	@PutMapping("/attribut/{id}")
	public ResponseEntity<Attribut> updateAttribut(@PathVariable Long id , @RequestBody Attribut attributDetails){
		Attribut attribut = attributsRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("attribut not exist with id:" + id));
	
		attribut.setNomtype(attributDetails.getNomtype());
		attribut.setCartes(attributDetails.getCartes());
		attribut.setClients(attributDetails.getClients());
		attribut.setEquipements(attributDetails.getEquipements());
		attribut.setPntattach(attributDetails.getPntattach());
		attribut.setPorts(attributDetails.getPorts());
		attribut.setRegions(attributDetails.getRegions());
		attribut.setServices(attributDetails.getServices());
		attribut.setSites(attributDetails.getSites());
		attribut.setTaille(attributDetails.getTaille());
		attribut.setTypevaleur(attributDetails.getTypevaleur());
		attribut.setValeurreq(attributDetails.isValeurreq());
		
		
	
	
	
	
	
	Attribut updatedAttribut = attributsRepository.save(attribut);
	
		
		return ResponseEntity.ok(updatedAttribut);
	}
	
	@DeleteMapping("/attribut/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAttribut(@PathVariable Long id){
		Attribut attribut= attributsRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("attributs not exist with id:" + id));
		
		attributsRepository.delete(attribut);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
		
	}
	
	
	
	
	
	

}

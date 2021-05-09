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
import com.example.equip.model.Clientt;
import com.example.equip.model.Equipement;
import com.example.equip.model.Ressource;
import com.example.equip.repository.CarteRepository;
import com.example.equip.repository.EquipementRepository;
import com.example.equip.repository.RessourceRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class RessourceController {
	@Autowired
	private EquipementRepository equipementRepository;
	
	@Autowired
	private CarteRepository carteRepository;
	
	@Autowired
	private RessourceRepository ressourceRepository;
	
	@GetMapping("/ressource")
	public List<Ressource> getAllRessource() {
		
	    return ressourceRepository.findAll();
	}

	@GetMapping("/ressource/{id}")
	public ResponseEntity<Ressource> getRessourceById(@PathVariable Long id) {
	   
		Ressource ressource = ressourceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		return ResponseEntity.ok(ressource);
	}
	
	@PostMapping("/ressource")
	public Ressource AddRessource(@RequestBody Ressource ressource) {
	    return ressourceRepository.save(ressource);
	}
	
	@PutMapping("/ressource/{id}")
	public ResponseEntity<Ressource> updateRessource(@PathVariable Long id , @RequestBody Ressource ressourceDetails){
		Ressource ressource = ressourceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Ressource not exist with id:" + id));
	
	ressource.setNom(ressourceDetails.getNom());
	ressource.setNombre(ressourceDetails.getNombre());
	ressource.setCartes(ressourceDetails.getCartes());
	ressource.setEquipements(ressourceDetails.getEquipements());
	ressource.setPoint_att(ressourceDetails.getPoint_att());
	ressource.setServices(ressourceDetails.getServices());
	ressource.setType(ressourceDetails.getType());
	
	
	
	
	Ressource updatedRessource = ressourceRepository.save(ressource);
	
		
		return ResponseEntity.ok(updatedRessource);
	}
	
	@DeleteMapping("/ressource/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRessource(@PathVariable Long id){
		Ressource  ressource= ressourceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Ressource not exist with id:" + id));
		
		ressourceRepository.delete(ressource);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
		
	}
	
	
	
	
	

}

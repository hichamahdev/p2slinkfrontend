package com.example.equip.comtrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.example.equip.model.Anneau;
import com.example.equip.model.Equipement;
import com.example.equip.model.site;
import com.example.equip.repository.AnneauRepository;
import com.example.equip.repository.EquipementRepository;
import com.example.equip.repository.siteRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AnneauController {
	
	@Autowired
	private AnneauRepository anneauRepository;
	
	@Autowired
	private siteRepository siteRepository;
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@GetMapping("/anneau")
	public List<Anneau> getAllsites() {
		
	    return anneauRepository.findAll();
	}

	@GetMapping("/anneau/{id}")
	public ResponseEntity<Anneau> getAnneauById(@PathVariable Long id) {
	   
		Anneau anneau = anneauRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("anneau not exist with id:" + id));
		return ResponseEntity.ok(anneau);
			
	}
	
	
	
	@PostMapping("/anneau")
	public Anneau AddAnneau(@RequestBody Anneau anneau) {
	    return anneauRepository.save(anneau);
	}
	
	@PutMapping("/anneau/{id}")
	public ResponseEntity<Anneau> updateAnneau(@PathVariable Long id , @RequestBody Anneau anneauDetails){
		Anneau anneau = anneauRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
	
		anneau.setNom(anneauDetails.getNom());
		anneau.setType(anneauDetails.getType());
		
		anneau.setNotes(anneauDetails.getNotes());
		
		
		Anneau updatedanneau = anneauRepository.save(anneau);
		
		return ResponseEntity.ok(updatedanneau);
	}
	
	@DeleteMapping("/anneau/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAnneau(@PathVariable Long id){
		Anneau anneau = anneauRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		anneauRepository.delete(anneau);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
		
	}
	
	@PostMapping("/anneau/{id_anneau}/{id_equipement}")
	public Anneau AddEquipementAnneau(@PathVariable Long id_anneau,@PathVariable Long id_equipement,@RequestBody Anneau anneauEquip) {
		Anneau anneau = anneauRepository.findById(id_anneau)
				.orElseThrow(() -> new RessourceNotFoundException("Anneau not exist with id:" + id_anneau));
		Equipement equipement = equipementRepository.findById(id_equipement)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_equipement));
		
		List <Equipement> equipements = anneau.getEquipements();
		equipements.add(equipement);
		anneau.setEquipements(equipements);
		 Anneau updatedAnneau = anneauRepository.save(anneau);
		 
		 return updatedAnneau;
	}
	@GetMapping("/anneau/equipement/{id}")
	public List<Equipement> GetEquipementByAnneau(@PathVariable Long id) {
	    Optional<Anneau> anneau = anneauRepository.findById(id);		
	    if(anneau.isPresent()) {
		return anneau.get().getEquipements();
	    }		
	    return null;
	}
	
	
	@GetMapping("/anneau/{id}/site")
	public List<site> GetSiteByAnneau(@PathVariable Long id) {
	    Optional<Anneau> anneau = anneauRepository.findById(id);		
	    if(anneau.isPresent()) {
		return anneau.get().getSites();
	    }		
	    return null;
	}
	
	
	
	
	
	
	
	
	
}

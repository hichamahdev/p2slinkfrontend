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
import com.example.equip.model.Carte;
import com.example.equip.model.Equipement;
import com.example.equip.model.site;
import com.example.equip.repository.EquipementRepository;
import com.example.equip.repository.siteRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class siteController {
	@Autowired
	private siteRepository siteRepository;
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@GetMapping("/site")
	public List<site> getAllsites() {
		
	    return siteRepository.findAll();
	}

	@GetMapping("/site/{id}")
	public ResponseEntity<site> getSiteById(@PathVariable Long id) {
	   
		site site = siteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("site not exist with id:" + id));
		return ResponseEntity.ok(site);
			
	}
	
	
	
	@PostMapping("/site")
	public site AddSite(@RequestBody site site) {
	    return siteRepository.save(site);
	}
	
	@PutMapping("/site/{id}")
	public ResponseEntity<site> updateSite(@PathVariable Long id , @RequestBody site siteDetails){
		site site = siteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
	
		site.setNom(siteDetails.getNom());
		site.setType(siteDetails.getType());
		
		site.setNotes(siteDetails.getNotes());
		
		
		site updatedSite = siteRepository.save(site);
		
		return ResponseEntity.ok(updatedSite);
	}
	
	@DeleteMapping("/site/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSite(@PathVariable Long id){
		site site = siteRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		siteRepository.delete(site);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
		
	}
	
	@PostMapping("/site/{id_site}/{id_equipement}")
	public site AddEquipementSite(@PathVariable Long id_site,@PathVariable Long id_equipement,@RequestBody site siteEquip) {
		site site = siteRepository.findById(id_site)
				.orElseThrow(() -> new RessourceNotFoundException("site not exist with id:" + id_site));
		Equipement equipement = equipementRepository.findById(id_equipement)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_equipement));
		
		List <Equipement> equipements = site.getEquipement();
		equipements.add(equipement);
		site.setEquipement(equipements);
		 site updatedSite = siteRepository.save(site);
		 
		 return updatedSite;
	}
	@GetMapping("/site/{id}/equipement")
	public List<Equipement> GetEquipementBySite(@PathVariable Long id) {
	    Optional<site> site = siteRepository.findById(id);		
	    if(site.isPresent()) {
		return site.get().getEquipement();
	    }		
	    return null;
	}
	@GetMapping("/site/region")
	public List<site> getAllSiteWithoutRegion() {
		
	    return siteRepository.findSiteWithoutRegion();
	}
	
	
	

}

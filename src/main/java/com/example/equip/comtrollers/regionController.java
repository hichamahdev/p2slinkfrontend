package com.example.equip.comtrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.plaf.synth.Region;

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
import com.example.equip.model.Clientt;
import com.example.equip.model.region;
import com.example.equip.model.site;
import com.example.equip.repository.AnneauRepository;
import com.example.equip.repository.regionRepository;
import com.example.equip.repository.siteRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class regionController {
	@Autowired
	private regionRepository regionRepository;
	
	@Autowired
	private siteRepository siteRepository;
	
	@Autowired
	private AnneauRepository anneauRepository;
	
	@GetMapping("/region")
	public List<region> getAllRegions() {
		
	    return regionRepository.findAll();
	}

	@GetMapping("/region/{id}")
	public ResponseEntity<region> getRegionById(@PathVariable Long id) {
	   
		region region = regionRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Region not exist with id:" + id));
		return ResponseEntity.ok(region);
	}
	
	@GetMapping("/region/{id}/site")
	public List<site> GetSiteByRegion(@PathVariable Long id) {
	    Optional<region> region = regionRepository.findById(id);		
	    if(region.isPresent()) {
		return region.get().getSite();
	    }		
	    return null;
	}
	
	
	
	@PostMapping("/region")
	public region AddRegion(@RequestBody region region) {
	    return regionRepository.save(region);
	}
	@PostMapping("/region/{id_region}/{id_site}")
	public region AddSiteRegion(@PathVariable Long id_region,@PathVariable Long id_site,@RequestBody region regionSite) {
		region region = regionRepository.findById(id_region)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_region));
		site site = siteRepository.findById(id_site)
				.orElseThrow(() -> new RessourceNotFoundException("Carte not exist with id:" + id_site));
		
		List <site> sites = region.getSite();
		sites.add(site);
		region.setSite(sites);
		region updatedregion = regionRepository.save(region);
		 
		 return updatedregion;
	}
	
	@PutMapping("/region/{id}")
	public ResponseEntity<region> updateRegion(@PathVariable Long id , @RequestBody region regionDetai){
		region region = regionRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
	
		region.setNom(regionDetai.getNom());
		region.setNote(regionDetai.getNote());
		
		
		
		
		region updatedregion = regionRepository.save(region);
		
		return ResponseEntity.ok(updatedregion);
	}
	
	@DeleteMapping("/region/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRegion(@PathVariable Long id){
		region region= regionRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		regionRepository.delete(region);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/region/anneau/{id}")
	public List<Anneau> GetAnneauByRegion(@PathVariable Long id) {
		
	    Optional<region> region = regionRepository.findById(id);		
	    if(region.isPresent()) {
		return region.get().getAnneau();
	    }		
	    return null;
	}
	
	@PostMapping("/region/anneau/{id_region}/{id_anneau}")
	public region AddAnneauRegion(@PathVariable Long id_region,@PathVariable Long id_anneau,@RequestBody region regionAnneau) {
		region region = regionRepository.findById(id_region)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_region));
		Anneau anneau = anneauRepository.findById(id_anneau)
				.orElseThrow(() -> new RessourceNotFoundException("Carte not exist with id:" + id_anneau));
		
		List <Anneau> anneaux = region.getAnneau();
		anneaux.add(anneau);
		region.setAnneau(anneaux);
		region updatedregion = regionRepository.save(region);
		 
		 return updatedregion;
	}
	


}

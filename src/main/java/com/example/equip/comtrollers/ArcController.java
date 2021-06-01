package com.example.equip.comtrollers;

import java.util.ArrayList;
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

import com.example.equip.repository.regionRepository;
import com.example.equip.exception.RessourceNotFoundException;
import com.example.equip.model.Anneau;
import com.example.equip.model.Arc;
import com.example.equip.model.Slot;
import com.example.equip.model.Equipement;
import com.example.equip.model.region;

import com.example.equip.model.Port;
import com.example.equip.repository.AnneauRepository;
import com.example.equip.repository.ArcRepository;
import com.example.equip.repository.EquipementRepository;
import com.example.equip.repository.PortRepository;
import com.example.equip.repository.SlotRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class ArcController {

	@Autowired
	private ArcRepository arcRepository;
	
	@Autowired
	private regionRepository regionRepository;
	
	@Autowired
	private AnneauRepository anneauRepository;
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@Autowired
	private SlotRepository slotRepository;
	
	@Autowired
	private PortRepository portRepository;
	
	
	@GetMapping("/arc")
	public List<Arc> getAllArc() {
		
	    return arcRepository.findAll();
	}

	@GetMapping("/arc/{id}")
	public ResponseEntity<Arc> getArcById(@PathVariable Long id) {
	   
		Arc arc = arcRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Arc not exist with id:" + id));
		return ResponseEntity.ok(arc);
			
	}
	
	@PostMapping("/arc")
	public Arc AddArc(@RequestBody Arc arc) {
		
		
	    return arcRepository.save(arc);
	}
	
	@PutMapping("/arc/{id}")
	public ResponseEntity<Arc> updateArc(@PathVariable Long id , @RequestBody Arc arcDetails){
		Arc arc = arcRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("arc not exist with id:" + id));
	
		arc.setNom(arcDetails.getNom());
		arc.setAnneau(arcDetails.getAnneau());
		arc.setEquipement(arcDetails.getEquipement());
		arc.setPort(arcDetails.getPort());
		arc.setRegion(arcDetails.getRegion());
		arc.setNom(arcDetails.getNom());
		
		Arc arcedupdat = arcRepository.save(arc);
		
		return ResponseEntity.ok(arcedupdat);
	}
	
	@DeleteMapping("/arc/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteArc(@PathVariable Long id){
		Arc arc = arcRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		arcRepository.delete(arc);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);	
	}
	
	@PostMapping("/arc/region/{id_arc}/{id_region}")
	public Arc AddRegionArc(@PathVariable Long id_arc,@PathVariable Long id_region,@RequestBody Arc arc) {
		Arc arcs = arcRepository.findById(id_arc)
				.orElseThrow(() -> new RessourceNotFoundException("site not exist with id:" + id_arc));
		region region = regionRepository.findById(id_region)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_region));
		
		List <region> regions = new ArrayList<region>();
		
		regions = arcs.getRegion();
		regions.add(region);
		arcs.setRegion(regions);
		
		
		Arc updatArc = arcRepository.save(arcs);
		
		return updatArc;
	}
	
	
	
	@PostMapping("/arc/{id_arc}/{id_region}/{id_anneau}/{id_equip}/{id_slot}/{id_port}")
	public Arc AddRegionAnneauuArc(@PathVariable Long id_arc, @PathVariable Long id_region, @PathVariable Long id_anneau,@PathVariable Long id_equip,@PathVariable Long id_slot,@PathVariable Long id_port,@RequestBody Arc arc) {
		Arc arcs = arcRepository.findById(id_arc)
				.orElseThrow(() -> new RessourceNotFoundException("site not exist with id:" + id_arc));
		region region = regionRepository.findById(id_region)
				.orElseThrow(() -> new RessourceNotFoundException("region not exist with id:" + id_region));
		
		Anneau anneau = anneauRepository.findById(id_anneau)
				.orElseThrow(() -> new RessourceNotFoundException("anneau not exist with id:" + id_anneau));
		
		Equipement equipement= equipementRepository.findById(id_equip)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_equip));
		
		
		Slot slot = slotRepository.findById(id_slot)
				.orElseThrow(() -> new RessourceNotFoundException("slot not exist with id:" + id_slot));
	
		Port port= portRepository.findById(id_port)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_port));
		
		List <region> regions = new ArrayList<region>();
		List <Anneau> anneaux = new ArrayList<Anneau>();
		List <Equipement> equipements = new ArrayList<Equipement>();
		List <Slot> slots = new ArrayList<Slot>();
		List <Port> ports = new ArrayList<Port>();
		
		
		anneaux=arcs.getAnneau();
		anneaux.add(anneau);
		arcs.setAnneau(anneaux);
		
		
		regions = arcs.getRegion();
		regions.add(region);
		arcs.setRegion(regions);
		
		equipements = arcs.getEquipement();
		equipements.add(equipement);
		arcs.setEquipement(equipements);
		
		slots = arcs.getSlot();
		slots.add(slot);
		arcs.setSlot(slots);
		
		ports = arcs.getPort();
		port.setConnecte(true);
		portRepository.save(port);
		ports.add(port);
		arcs.setPort(ports);
		
		
		
		Arc updatArc = arcRepository.save(arcs);
		
		return updatArc;
	}
	
	
	
	
}

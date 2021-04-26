package com.example.equip.comtrollers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
import com.example.equip.model.PortEquip;
import com.example.equip.model.Slot;
import com.example.equip.repository.CarteRepository;
import com.example.equip.repository.EquipementRepository;
import com.example.equip.repository.SlotRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class equipementController {
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@Autowired
	private CarteRepository carteRepository;
	
	@Autowired
	private SlotRepository slotRepository;
	
	@GetMapping("/equipements")
	public List<Equipement> getAllEquipements() {
		
	    return equipementRepository.findAll();
	}

	@GetMapping("/equipements/{id}")
	public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
	   
		Equipement equipement = equipementRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		return ResponseEntity.ok(equipement);
	}
	
	
	
	@GetMapping("/equipements/{id}/port")
	public List<PortEquip> GetPortByEquipement(@PathVariable Long id) {
	    Optional<Equipement> equipement = equipementRepository.findById(id);		
	    if(equipement.isPresent()) {
		return equipement.get().getPortEquip();
	    }		
	    return null;
	}
	
	@PostMapping("/equipements")
	public Equipement AddEquipement(@RequestBody Equipement equipement) {
		List<Slot> slot = equipement.getSlot();
		slot = new ArrayList<Slot>(equipement.getNumbSlot());
		for(int i=0; i<equipement.getNumbSlot() ; i++) {
			Slot slott = new Slot();
			slott.setNomSlot("S"+(i+1));
			slott.setNumeroSlot(i+1);
			slott.setSlotFin(equipement.getNumeroSlotFin());
			slott.setSlotMin(equipement.getNumeroSlotMin());
			
			slotRepository.save(slott);
			slot.add(slott);
		}
		equipement.setSlot(slot);
	    return equipementRepository.save(equipement);
	}
	
	
	@PutMapping("/equipements/{id}")
	public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id , @RequestBody Equipement equipementDetai){
		Equipement equipement = equipementRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
	
		equipement.setNomSupEquip(equipementDetai.getNomSupEquip());
		equipement.setNomEquip(equipementDetai.getNomEquip());
		equipement.setCategorieEquip(equipementDetai.getCategorieEquip());
		equipement.setNumbSlot(equipementDetai.getNumbSlot());
		equipement.setDebitMax(equipementDetai.getDebitMax());
		equipement.setNumeroSlotFin(equipementDetai.getNumeroSlotFin());
		equipement.setNumeroSlotMin(equipementDetai.getNumeroSlotMin());
		equipement.setSlot(equipementDetai.getSlot());
		
		
		
		Equipement updatedEquipement = equipementRepository.save(equipement);
		
		return ResponseEntity.ok(updatedEquipement);
	}
	
	@DeleteMapping("/equipements/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEquipement(@PathVariable Long id){
		Equipement equipement= equipementRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		equipementRepository.delete(equipement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/equipements/site")
	public List<Equipement> getAllEquipementwithoutsite() {
		
	    return equipementRepository.findEquipementWithoutSite();
	}
	
	

	

	
	
			
	}



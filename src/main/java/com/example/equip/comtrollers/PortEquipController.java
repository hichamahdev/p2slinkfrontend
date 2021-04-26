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

import com.example.equip.model.PortEquip;
import com.example.equip.repository.PortEquipRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class PortEquipController {
	@Autowired
	private PortEquipRepository portEquipRepository;
	
	@GetMapping("/portequip")
	public List<PortEquip> getAllPorts() {
		
	    return portEquipRepository.findAll();
	}

	@GetMapping("/portequip/{id}")
	public ResponseEntity<PortEquip> getPortEquipById(@PathVariable Long id) {
	   
		PortEquip portEquip = portEquipRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
		return ResponseEntity.ok(portEquip);
			
	}
	@PostMapping("/portequip")
	public PortEquip AddEquip(@RequestBody PortEquip portEquip) {
	    return portEquipRepository.save(portEquip);
	}
	
	@PutMapping("/portequip/{id}")
	public ResponseEntity<PortEquip> updatePortEquip(@PathVariable Long id , @RequestBody PortEquip portEquipDetails){
		PortEquip portEquip = portEquipRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
	
		portEquip.setNomPort(portEquipDetails.getNomPort());
		portEquip.setTypePort(portEquipDetails.getTypePort());
		portEquip.setServicePort(portEquipDetails.getServicePort());
		portEquip.setPuissancePort(portEquipDetails.getPuissancePort());
		portEquip.setEquipementid(portEquipDetails.getEquipementid());
		
		PortEquip updatedPortEquip = portEquipRepository.save(portEquip);
		
		return ResponseEntity.ok(updatedPortEquip);
	}
	
	@DeleteMapping("/portequip/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePort(@PathVariable Long id){
		PortEquip portEquip = portEquipRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
	
		portEquipRepository.delete(portEquip);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
		
	}
	


}

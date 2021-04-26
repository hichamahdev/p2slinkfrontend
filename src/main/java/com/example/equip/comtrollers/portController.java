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
import com.example.equip.model.Carte;
import com.example.equip.model.Port;
import com.example.equip.repository.PortRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class portController {

	
	@Autowired
	private PortRepository portRepository;
	
	@GetMapping("/port")
	public List<Port> getAllPorts() {
		
	    return portRepository.findAll();
	}

	@GetMapping("/port/{id}")
	public ResponseEntity<Port> getPortById(@PathVariable Long id) {
	   
		Port port = portRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
		return ResponseEntity.ok(port);
			
	}
	@PostMapping("/port")
	public Port AddPort(@RequestBody Port port) {
	    return portRepository.save(port);
	}
	
	@PutMapping("/port/{id}")
	public ResponseEntity<Port> updatePort(@PathVariable Long id , @RequestBody Port portDetails){
		Port port = portRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
	
		port.setNomPort(portDetails.getNomPort());
		port.setTypePort(portDetails.getTypePort());
		port.setServicePort(portDetails.getServicePort());
		port.setPuissancePort(portDetails.getPuissancePort());
		port.setCarteid(portDetails.getCarteid());
		
		Port updatedPort = portRepository.save(port);
		
		return ResponseEntity.ok(updatedPort);
	}
	
	@DeleteMapping("/port/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePort(@PathVariable Long id){
		Port port = portRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
	
		portRepository.delete(port);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
		
	}
	
}

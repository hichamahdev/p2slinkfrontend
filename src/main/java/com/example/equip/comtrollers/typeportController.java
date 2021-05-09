package com.example.equip.comtrollers;

import java.util.ArrayList;
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
import com.example.equip.model.Port;
import com.example.equip.model.Typeport;
import com.example.equip.repository.typeportRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class typeportController {
	
	@Autowired
	private typeportRepository typeportRepository;
	
	
	@GetMapping("/typeport")
	public List<Typeport> getAlltypeport() {
		
	    return typeportRepository.findAll();
	}

	@GetMapping("/typeport/{id}")
	public ResponseEntity<Typeport> gettypeportById(@PathVariable Long id) {
	   
		Typeport typeport= typeportRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("typeport not exist with id:" + id));
		return ResponseEntity.ok(typeport);
			
	}
	
	
	
	@PostMapping("/typeport")
	public Typeport Addtypeport(@RequestBody Typeport typeport) {
		
		
		
	    return typeportRepository.save(typeport);
	}
	
	@PutMapping("/typeport/{id}")
	public ResponseEntity<Typeport> updatetypeport(@PathVariable Long id , @RequestBody Typeport typeportDetails){
		Typeport typeport = typeportRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("typeport not exist with id:" + id));
	
		typeport.setNom(typeportDetails.getNom());
		
		
		
		
		
		Typeport updatedtypeport = typeportRepository.save(typeport);
		
		return ResponseEntity.ok(updatedtypeport);
	}
	
	@DeleteMapping("/typeport/{id}")
	public ResponseEntity<Map<String, Boolean>> deletetypeport(@PathVariable Long id){
		Typeport typeport = typeportRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("typeport not exist with id:" + id));
		
		typeportRepository.delete(typeport);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);	
	}
	
	

}

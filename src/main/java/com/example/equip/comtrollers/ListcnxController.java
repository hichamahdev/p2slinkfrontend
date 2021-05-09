package com.example.equip.comtrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.equip.exception.RessourceNotFoundException;
import com.example.equip.model.Listecnx;
import com.example.equip.model.Typeport;
import com.example.equip.repository.ListcnxRepository;

public class ListcnxController {
	
	@Autowired
	private ListcnxRepository listcnxRepository;
	
	
	@GetMapping("/listcnx")
	public List<Listecnx> getAllListcnx() {
		
	    return listcnxRepository.findAll();
	}

	@GetMapping("/listcnx/{id}")
	public ResponseEntity<Listecnx> getListcnxById(@PathVariable Long id) {
	   
		Listecnx listecnx= listcnxRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("listcnx not exist with id:" + id));
		return ResponseEntity.ok(listecnx);
			
	}
	
	
	
	@PostMapping("/listcnx")
	public Listecnx Addlistcnx(@RequestBody Listecnx listecnx) {
		
		
		
	    return listcnxRepository.save(listecnx);
	}
	
	@PutMapping("/typeport/{id}")
	public ResponseEntity<Listecnx> updateListcnx(@PathVariable Long id , @RequestBody Listecnx listecnxDetails){
		Listecnx listecnx = listcnxRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("typeport not exist with id:" + id));
	
		listecnx.setTypeporta(listecnxDetails.getTypeporta());
		listecnx.setTypeportb(listecnxDetails.getTypeportb());
		
		
		
		
		
		Listecnx updatedlistcnx = listcnxRepository.save(listecnx);
		
		return ResponseEntity.ok(updatedlistcnx);
	}
	
	@DeleteMapping("/typeport/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteListecnx(@PathVariable Long id){
		Listecnx listcnx = listcnxRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("typeport not exist with id:" + id));
		
		listcnxRepository.delete(listcnx);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);	
	}
	
	

}

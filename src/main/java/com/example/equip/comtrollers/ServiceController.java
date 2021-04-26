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
import com.example.equip.model.Servicee;
import com.example.equip.model.site;
import com.example.equip.repository.ServiceRepository;
import com.example.equip.repository.siteRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class ServiceController {
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@GetMapping("/service")
	public List<Servicee> getAllService() {
		
	    return serviceRepository.findAll();
	}

	@GetMapping("/service/{id}")
	public ResponseEntity<Servicee> getServiceById(@PathVariable Long id) {
	   
		Servicee service = serviceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("site not exist with id:" + id));
		return ResponseEntity.ok(service);
			
	}
	
	
	
	@PostMapping("/service")
	public Servicee AddSite(@RequestBody Servicee service) {
	    return serviceRepository.save(service);
	}
	
	@PutMapping("/service/{id}")
	public ResponseEntity<Servicee> updateService(@PathVariable Long id , @RequestBody Servicee serviceDetails){
		Servicee service = serviceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
	
		service.setReference(serviceDetails.getReference());
		service.setIdetinfiantServ(serviceDetails.getIdetinfiantServ());
		service.setNomService(serviceDetails.getNomService());
		service.setTypeService(service.getTypeService());

				
		Servicee updatedService = serviceRepository.save(service);
		
		return ResponseEntity.ok(updatedService);
	}
	
	@DeleteMapping("/service/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteService(@PathVariable Long id){
	Servicee service= serviceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		serviceRepository.delete(service);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);	
		
	}

}

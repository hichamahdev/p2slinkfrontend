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
import com.example.equip.model.Clientt;
import com.example.equip.model.Servicee;
import com.example.equip.model.region;
import com.example.equip.model.site;
import com.example.equip.repository.ClientRepository;
import com.example.equip.repository.ServiceRepository;




@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	
	@GetMapping("/client")
	public List<Clientt> getAllClients() {
		
	    return clientRepository.findAll();
	}
	
	
	@GetMapping("/client/{id}")
	public ResponseEntity<Clientt> getClientById(@PathVariable Long id) {
	   
		Clientt client = clientRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("site not exist with id:" + id));
		return ResponseEntity.ok(client);
			
	}

	@PostMapping("/client")
	public Clientt AddClient(@RequestBody Clientt client) {
	    return clientRepository.save(client);
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<Clientt> updateClient(@PathVariable Long id , @RequestBody Clientt clientDetails){
		Clientt client = clientRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("port not exist with id:" + id));
	
	client.setReference(clientDetails.getReference());
	client.setIdentifiant(clientDetails.getIdentifiant());
	client.setAdress1(clientDetails.getAdress1());
	client.setAdress2(clientDetails.getAdress2());
	client.setAdress3(clientDetails.getAdress3());
	client.setDepartement(clientDetails.getDepartement());
	client.setCodePostale(clientDetails.getCodePostale());
	client.setVille(clientDetails.getVille());
	client.setPays(clientDetails.getPays());
	
	client.setNomClient(clientDetails.getNomClient());
	
	Clientt updatedClient = clientRepository.save(client);
	
		
		return ResponseEntity.ok(updatedClient);
	}
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id){
		Clientt client = clientRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
		
	}
	
	@GetMapping("/client/{id}/service")
	public List<Servicee> GetServiceByclient(@PathVariable Long id) {
	    Optional<Clientt> client = clientRepository.findById(id);		
	    if(client.isPresent()) {
		return client.get().getService();
	    }		
	    return null;
	}
	@PostMapping("/client/{id_client}/{id_service}")
	public Clientt AddServiceClient(@PathVariable Long id_client,@PathVariable Long id_service,@RequestBody Clientt clientSite) {
		Clientt client = clientRepository.findById(id_client)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_client));
		Servicee service = serviceRepository.findById(id_service)
				.orElseThrow(() -> new RessourceNotFoundException("Carte not exist with id:" + id_service));
		
		List <Servicee> services = client.getService();
		services.add(service);
		client.setService(services);
		Clientt updateClient = clientRepository.save(client);
		 
		 return updateClient;
	}

}

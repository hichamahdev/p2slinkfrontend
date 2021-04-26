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
import com.example.equip.model.Slot;
import com.example.equip.model.site;
import com.example.equip.repository.CarteRepository;
import com.example.equip.repository.SlotRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class SlotController {
	
	@Autowired
	private SlotRepository slotRepository;
	
	@Autowired
	private CarteRepository carteRepository;
	
	
	
	@GetMapping("/slot")
	public List<Slot> getAllslot() {
		
	    return slotRepository.findAll();
	}

	@GetMapping("/slot/{id}")
	public ResponseEntity<Slot> getSlotById(@PathVariable Long id) {
	   
		Slot slot = slotRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("site not exist with id:" + id));
		return ResponseEntity.ok(slot);
			
	}
	
	
	
	@PostMapping("/slot")
	public Slot AddSlot(@RequestBody Slot slot) {
	    return slotRepository.save(slot);
	}
	
	@PutMapping("/slot/{id}")
	public ResponseEntity<Slot> updateSlot(@PathVariable Long id , @RequestBody Slot slotDetails){
		Slot slot = slotRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("slot not exist with id:" + id));
	
		slot.setNomSlot(slotDetails.getNomSlot());
		slot.setTypeslot(slotDetails.getTypeslot());
		
		slot.setNumeroSlot(slotDetails.getNumeroSlot());
		
		
		Slot updatedSlot = slotRepository.save(slot);
		
		return ResponseEntity.ok(updatedSlot);
	}
	
	@DeleteMapping("/slot/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSlot(@PathVariable Long id){
		Slot slot = slotRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id));
		
		slotRepository.delete(slot);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
			
	}
	
	@PostMapping("/slot/{id_slot}/{id_carte}")
	public Slot AddCarteSlot(@PathVariable Long id_slot,@PathVariable Long id_carte, @RequestBody Slot slot) {
		Slot sloti = slotRepository.findById(id_slot)
				.orElseThrow(() -> new RessourceNotFoundException("site not exist with id:" + id_slot));
		Carte carte = carteRepository.findById(id_carte)
				.orElseThrow(() -> new RessourceNotFoundException("Equipement not exist with id:" + id_carte));
		
		slot.setCarte(carte);
		
		Slot updatSlot = slotRepository.save(slot);
		
		return updatSlot;
	}
	
}
		
	
	
	
	



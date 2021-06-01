package com.example.equip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.equip.model.Slot;


public interface SlotRepository extends JpaRepository<Slot, Long> {
	
	
	@Query(
			value = "SELECT * FROM slot WHERE carte_id IS NOT null ",
			nativeQuery = true
			)
	public List<Slot> findSlotwithcarte();
}

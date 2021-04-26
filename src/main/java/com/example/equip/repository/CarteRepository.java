package com.example.equip.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository
;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.equip.model.Carte;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long> {
	
	@Query(
			  value = "SELECT * FROM Carte  WHERE slot_id=0", 
			  nativeQuery = true)
	public List<Carte> findCarteWithoutSlot();
}

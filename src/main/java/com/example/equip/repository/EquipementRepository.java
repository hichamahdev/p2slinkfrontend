package com.example.equip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.equip.model.Carte;
import com.example.equip.model.Equipement;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement,Long> {
	
	@Query(
			  value = "SELECT * FROM equipements  WHERE site_id IS null", 
			  nativeQuery = true)
	public List<Equipement>findEquipementWithoutSite();
}

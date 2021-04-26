package com.example.equip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.equip.model.site;

public interface siteRepository extends JpaRepository<site, Long> {
	@Query(
			  value = "SELECT * FROM Site  WHERE region_id IS null", 
			  nativeQuery = true)
	public List<site>findSiteWithoutRegion();

}

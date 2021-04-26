package com.example.equip.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import  com.example.equip.model.Servicee;



public interface ServiceRepository extends JpaRepository<Servicee, Long> {

}

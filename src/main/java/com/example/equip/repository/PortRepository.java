package com.example.equip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.equip.model.Port;

@Repository
public interface PortRepository extends JpaRepository<Port, Long> {

}

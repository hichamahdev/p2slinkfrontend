package com.example.equip.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





import com.example.equip.model.Role;
import com.example.equip.model.RoleName;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByName(RoleName roleName);

}

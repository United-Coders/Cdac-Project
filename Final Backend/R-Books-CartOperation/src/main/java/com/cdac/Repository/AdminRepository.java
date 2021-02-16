package com.cdac.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Admin;
import com.cdac.dto.User;




@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findByEmailAndPassword(String email, String password);
	
	public Admin findByEmail(String email);
}

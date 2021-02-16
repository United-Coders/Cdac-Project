package com.cdac.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdac.dto.Librarian;
import com.cdac.dto.User;


public interface LibrarianRepository extends JpaRepository<Librarian, Integer>{
	public Librarian findByEmailAndPassword(String email, String password);
	
	public Librarian findByEmail(String email);
}

package com.cdac.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Books; 

@Repository("booksRepository")
public interface BooksRepository extends JpaRepository<Books, Integer> {
	//public Books findById(int BookId);
	
	// List<Books> findByBookname(String bookname);

}
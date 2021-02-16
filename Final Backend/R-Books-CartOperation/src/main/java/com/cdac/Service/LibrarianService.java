package com.cdac.Service;

import java.util.List;

import javax.mail.MessagingException;

import com.cdac.dto.Librarian;
import com.cdac.dto.User;

public interface LibrarianService {
	
	
    boolean AddLibrarian(Librarian librarian);
	
	List<Librarian> getAllLibrarian();
	
	boolean LibrarianValidate(Librarian librarian);
	
	boolean deleteLibrarian(int id);
	
	Librarian getLibrarianById(int id);
	
	
	boolean getLibrarianPass (Librarian librarian)throws MessagingException;
}

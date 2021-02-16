package com.cdac.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Controller.EmailController;
import com.cdac.Repository.LibrarianRepository;
import com.cdac.Repository.UserRepository;
import com.cdac.dto.Librarian;
import com.cdac.dto.User;

@Service
public class LibrarianServiceImple implements LibrarianService{

	@Autowired
	private LibrarianRepository librarianRepository;
	
	@Autowired
	private LibrarianService librarianService;
	
	
	@Autowired
	private EmailController emailController;
	
	@Override
	public boolean AddLibrarian(Librarian librarian) {
		if(null == librarianRepository.save(librarian)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Librarian> getAllLibrarian() {
		Iterable<Librarian> UI = librarianRepository.findAll();
		Iterator<Librarian> UItr = UI.iterator();
		List<Librarian> Lli = new ArrayList<Librarian>();
		while(UItr.hasNext()) {
			Lli.add(UItr.next());
		}
		return Lli;
	}

	@Override
	public boolean LibrarianValidate(Librarian librarian) {
		if(librarianRepository.findByEmailAndPassword(librarian.getEmail(), librarian.getPassword()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteLibrarian(int id) {
		librarianRepository.deleteById(id);
		return true;
	}

	@Override
	public Librarian getLibrarianById(int id) {
		return librarianService.getLibrarianById(id);
	}

	@Override
	public boolean getLibrarianPass(Librarian librarian) throws MessagingException {
	
		
			if(librarianRepository.findByEmail(librarian.getEmail())!= null) {
			
				Librarian us1 = librarianRepository.findByEmail(librarian.getEmail());
				
				emailController.sendPasswordEmail2(us1);
			
				
				return true;
			}
			
			return false;
		}
	

}

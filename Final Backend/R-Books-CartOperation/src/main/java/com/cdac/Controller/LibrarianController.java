package com.cdac.Controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Repository.LibrarianRepository;
import com.cdac.Service.LibrarianService;
import com.cdac.dto.Admin;
import com.cdac.dto.Librarian;
import com.cdac.dto.Message;
import com.cdac.dto.User;
import com.cdac.exception.ResourceNotFoundException;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LibrarianController {

	
	@Autowired
	private LibrarianService librarianService;
	@Autowired
	private LibrarianRepository librarianRepository;
	
	
	@PostMapping(value = "registerLibrarian")
	public Message index(@RequestBody Librarian librarian) {
			System.out.println(librarian);
			if(librarianService.AddLibrarian(librarian)) {
				return new Message("Librarian Registered", true);
			}
			
			return new Message("Librarian Already Registered", false);
	}
	
	@PostMapping(value = "LibrarianValidate")
	public Message LibrarianValidate(@RequestBody Librarian librarian) {
			System.out.println(librarian);
			if(librarianService.LibrarianValidate(librarian)) {
				return new Message("Librarian Validated", true);
			}
			return new Message("Invalid Credentials", false);
	}
	
	
	@DeleteMapping(value = "deleteLibrarian/{id}")
	public Message deleteLibrarian(@PathVariable int id) {
			System.out.println(id);
			librarianService.deleteLibrarian(id);
			return new Message("Record Removed",true);
	}
	
	@GetMapping(value = "Librarydisplay" )
	public List<Librarian> getLibrarian() {
			//System.out.println(id);
			
			return librarianService.getAllLibrarian();
	}
	
	
	@GetMapping("/getlibrarian/{id}")
	public ResponseEntity<Librarian> getUserById(@PathVariable Integer id) {
		Librarian librarian = librarianRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Librarian not exist with id :" + id));
		return ResponseEntity.ok(librarian);
	}
	
	
	@PutMapping("/update-librarian/{id}")
	public ResponseEntity<Librarian> updateUser(@PathVariable Integer id, @RequestBody Librarian LibrarianDetails){
		Librarian librarian = librarianRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("librarian not exist with id :" + id));
		
		librarian.setName(LibrarianDetails.getName());
		librarian.setEmail(LibrarianDetails.getEmail());
		librarian.setPassword(LibrarianDetails.getPassword());
		librarian.setPhone(LibrarianDetails.getPhone());
		librarian.setLicence_no(LibrarianDetails.getLicence_no());
		librarian.setAddress(LibrarianDetails.getAddress());
	
		
		Librarian Librarian = librarianRepository.save(librarian);
		System.out.println(Librarian);
		return ResponseEntity.ok(Librarian);
		
		
		
	}
	
	
	
	@PostMapping(value = "getLibPass")
	public Message getLibPass(@RequestBody Librarian librarian) throws MessagingException {
			System.out.println(librarian.getEmail());
			if(librarianService.getLibrarianPass(librarian)) {
				
				System.out.println(librarian.getPassword()+" is working");
				
				System.out.println(librarian.getEmail()+" is working");
				return new Message("Your Password is send to your Registerd Email Id", true);
				
			}
			System.out.println(librarian.getPhone()+"not working");
			return new Message("Invalid Email Id", false);
	}
}

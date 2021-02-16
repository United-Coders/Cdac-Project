package com.cdac.Controller;

import java.util.List;

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

import com.cdac.Repository.BooksRepository;
import com.cdac.Service.BooksService;
import com.cdac.dto.Books;
import com.cdac.dto.Message;
import com.cdac.exception.ResourceNotFoundException;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BooksController {

	@Autowired
	private BooksService booksService;
	
	@Autowired
	private BooksRepository booksRepository;
	
	@PostMapping(value = "AddBooks")
	public Message index(@RequestBody Books books) {
		System.out.println(books);
		if(booksService.AddBook(books)){
			return new Message("Book Added", true);
			}
			return new Message("Book Already Added", false);
		}
	
	@DeleteMapping(value = "deleteBooks/{id}")
	public Message deleteBook(@PathVariable int id) {
		System.out.println(id);
		booksService.deleteBook(id);
		return new Message("Books Removed",true);
	}
	
	@GetMapping(value = "Books")
	public List<Books> getBooks(){
		//System.out.println(id);
		return booksService.getAllBooks();
	}
	
	
	
//	@PutMapping("/Updatebooks")  
//	private void update(@RequestBody Books books)   
//	{  
//	booksService.update(books);
//	 
//	}  
	
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setEmailId(employeeDetails.getEmailId());
//		
//		Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
	
	@PutMapping("/update-books/{id}")
	public ResponseEntity<Books> updateBooks(@PathVariable Integer id, @RequestBody Books BooksDetails){
		Books books = booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		books.setBookname(BooksDetails.getBookname());
		books.setBookPrice(BooksDetails.getBookPrice());
		books.setAuthorName(BooksDetails.getAuthorName());
		books.setBookRent(BooksDetails.getBookRent());
		books.setDescription(BooksDetails.getDescription());
		books.setEdition(BooksDetails.getEdition());
		
		Books updatedBooks = booksRepository.save(books);
		System.out.println(updatedBooks);
		return ResponseEntity.ok(updatedBooks);
	}
	
	
	@GetMapping("/getbooks/{id}")
	public ResponseEntity<Books> getEmployeeById(@PathVariable Integer id) {
		Books books = booksRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));
		return ResponseEntity.ok(books);
	}
	
//	@GetMapping("/getbook")  
//	private void update(@PathVariable int id)   
//	{  
//	booksService.getBooksById(id);
//	 
//	}  
	
	
//	@PutMapping("/books/{id}")
//	public ResponseEntity<Books> updateBooks(@PathVariable Integer id, @RequestBody Books booksDetails){
//		
//		//Books books = booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" +id));
//		
////		books.setBookname(booksDetails.getBookname());
////		books.setBookPrice(booksDetails.getBookPrice());
////		books.setBookRent(booksDetails.getBookRent());
////		books.setAuthorName(booksDetails.getAuthorName());
////		books.setDescription(booksDetails.getDescription());
////		books.setEdition(booksDetails.getEdition());
//		
//		//Books updateBooks = booksRepository.save();
//		return null;
//	}
//	
//	@GetMapping("/Books/{id}")
//	public Books getBooksById(@PathVariable Integer id) {
//		List<Books> Books = booksService.findById(id);
//		return Books;
//		return booksService.findById(id);
//	}
	
//	@GetMapping("/Books/{id}")
//	public Books getBooksById(@PathVariable Integer id) {
//		Books Books = BooksRepository.find
//				findById(id).orElseThrow(() -> new ResourceNotF)
				//BooksRepository.findById(id).orElseThrow(exceptionSupplier)
//	}
	
	
//	@PutMapping("/Books/update/{id}")
//	public ResponseEntity<Books> updateBooks(Long id, @RequestBody Books books){
//		
//		
//		
//	}
	
//	@PutMapping("/Updatebooks/{id}")  
//	private void update(@RequestBody Books books,@PathVariable Integer id)   
//	{  
//	booksService.update(books, id);
//	 
//	}  

}

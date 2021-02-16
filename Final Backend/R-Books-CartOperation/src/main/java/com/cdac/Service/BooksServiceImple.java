package com.cdac.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cdac.Repository.BooksRepository;
import com.cdac.dto.Books;
import com.cdac.dto.User;


@Transactional
@Service("booksService")

public class BooksServiceImple implements BooksService{

	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private BooksService booksService;
	
	@Override
	public boolean AddBook(Books books) {
		if(null == booksRepository.save(books)){
			return false;
		}
		return true;
	}

	@Override
	public List<Books> getAllBooks() {
		Iterable<Books> BI = booksRepository.findAll();
		Iterator<Books> BItr = BI.iterator();
		List<Books> ULi = new ArrayList<Books>();
		while(BItr.hasNext()) {
			ULi.add(BItr.next());
		}
		return ULi;
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public boolean deleteBook(int id) {
		booksRepository.deleteById(id);
		return true;
		// TODO Auto-generated method stub
		//return null;
	}

//	@Override
//	public Books update(Books books) {
//		
//		return booksRepository.save(books);
//	}
	
	

	@Override
	public Books getBooksById(int id) {
		
		return booksService.getBooksById(id);
	}




	
	
//	@Override
//	public boolean UpdateBook(int id) {
//		booksRepository.
//		return false;
//	}

//	@PutMapping("/books/{id}")
//	public ResponseEntity<Books> updateBooks(@PathVariable Integer id, @RequestBody Books booksDetails){
		
		//Books books = booksRepository.findById(id); //.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" +id));
		
//		books.setBookname(booksDetails.getBookname());
//		books.setBookPrice(booksDetails.getBookPrice());
//		books.setBookRent(booksDetails.getBookRent());
//		books.setAuthorName(booksDetails.getAuthorName());
//		books.setDescription(booksDetails.getDescription());
//		books.setEdition(booksDetails.getEdition());
		
//		Books updateBooks = booksRepository.save();
//		return null;
//	}

//	@Override
//	public boolean UpdateBook(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void update(Books books, int id) {
//		booksRepository.save(books);
//		
//	}

}

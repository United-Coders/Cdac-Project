package com.cdac.Service;

import java.util.List;

import com.cdac.dto.Books;
import com.cdac.dto.User;


public interface BooksService {

	boolean AddBook(Books books);
	
	List<Books> getAllBooks();
	
	boolean deleteBook(int id);
	
	//boolean UpdateBook(int id);
	
    //void update(Books books, int id);
	
	//Books update(Books books);
	
	
	
	Books getBooksById(int id);
	
}

/*
*/
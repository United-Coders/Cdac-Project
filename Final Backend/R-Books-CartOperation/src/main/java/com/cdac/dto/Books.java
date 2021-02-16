package com.cdac.dto;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="books")
public class Books {

	@Id
	@GeneratedValue
   private int BookId;
   private String Bookname;
   private String AuthorName;
   private int BookRent;
   private int BookPrice;
   private String Edition;
   private String Description;
   
   
//   @Transient
//   private MultipartFile bookImage;
  
public Books() {
	super();
	// TODO Auto-generated constructor stub
}







//public MultipartFile getBookImage() {
//	return bookImage;
//}






//
//public void setBookImage(MultipartFile bookImage) {
//	this.bookImage = bookImage;
//}







public Books(int bookId, String bookname, String authorName, int bookRent, int bookPrice, String edition,
		String description, MultipartFile bookImage) {
	super();
	BookId = bookId;
	Bookname = bookname;
	AuthorName = authorName;
	BookRent = bookRent;
	BookPrice = bookPrice;
	Edition = edition;
	Description = description;
//	this.bookImage = bookImage;
}







public int getBookId(){
	return BookId;
}
public void setBookId(int bookId) {
	BookId = bookId;
}
public String getBookname() {
	return Bookname;
}
public void setBookname(String bookname) {
	Bookname = bookname;
}
public String getAuthorName() {
	return AuthorName;
}
public void setAuthorName(String authorName) {
	AuthorName = authorName;
}
public String getEdition() {
	return Edition;
}
public void setEdition(String edition) {
	Edition = edition;
}

public int getBookRent() {
	return BookRent;
}
public void setBookRent(int bookRent) {
	BookRent = bookRent;
}
public int getBookPrice() {
	return BookPrice;
}
public void setBookPrice(int bookPrice) {
	BookPrice = bookPrice;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}  
}
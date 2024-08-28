package com.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.Book;

@Controller
public class BookController {

	@Autowired
	BookRepository repo;

	// Adding Book Details
	@RequestMapping("/add-record")
	public String getAddBookFrmPage() {
		return "add-record";
	}

	@RequestMapping("/addBook")
	public String AddBook(Book b) {
		repo.save(b);
		return "add-record";
	}

	// Show All Books
	@ResponseBody
	@RequestMapping("/showAllBook")
	public List<Book> getShowAllBookPage() {
		List<Book> blist = (List<Book>) repo.findAll();
		return blist;
	}
	
	
	@RequestMapping("/update-book")
	public String updateBookPage() {
		return "update-book";
	}
	
	@RequestMapping("/updatebook")
	public String updateBook(@RequestParam("bookId") int bookId,
			@RequestParam("bookName") String bookName,@RequestParam("bookPrice") int bookPrice,@RequestParam("bookGenre") String bookGenre,
			@RequestParam("authorName") String authorName,@RequestParam("publishedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishedDate,
            Model model) {
		Book book = new Book();

	    Optional<Book> bookOptional = repo.findByBookId(bookId);
	    if (bookOptional.isPresent()) {
	         book = bookOptional.get();
	       // book.setBookId(book.getBookId());
	        book.setBookName(bookName);
	        book.setBookPrice(bookPrice);
	        book.setBookGenre(bookGenre);
	        book.setAuthorName(authorName);
	        
	        // Parse published date
	        book.setPublishedDate(publishedDate);
	        repo.save(book); // Save the changes to the database
	       model.addAttribute("message", "Book updated successfully!");
	        return "update-book";
	    }
	   model.addAttribute("message", "Book not found!");
	    return "update-book";
	}
	/*
	@PostMapping("/updatebook")
	@ResponseBody
	public String updateSaveBook(Book book, RedirectAttributes redirectAttributes) {
		if(repo.saveOrUpdateToDoItem(book)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "update-book";
		}
		
		redirectAttributes.addFlashAttribute("message", "Edit Failure");
		return "update-book" + book.getBookId();
	}
	
	*/
	
	//Delete using price range
	@RequestMapping("/delete-books-by-price/{minPrice}/{maxPrice}")
	@ResponseBody
	public String deleteBooksByPrice(@PathVariable("minPrice") double minPrice, @PathVariable("maxPrice") double maxPrice) {
	    repo.deleteByBookPriceBetween(minPrice, maxPrice);
	    return "Delete done B/w '"+minPrice+"' and '"+maxPrice+"' "; 
	}
	
	// Delete Operation By Book
	@RequestMapping("/delete-book/{bookName}")
	@ResponseBody
	public String deleteBook(@PathVariable("bookName") String bookName) {
	    Optional<Book> bookOptional = repo.findByBookName(bookName);
	    
	    if(bookOptional.isPresent()) {
	        Book book = bookOptional.get();
	        repo.delete(book);
	    }
	    return "Delete done"; 
	}

	// Searching book by Name
	@ResponseBody
	@RequestMapping("/showByName/{bookName}")
	public Optional<Book> showByName(@PathVariable("bookName") String bookName) {
		Optional<Book> b = repo.findByBookName(bookName);
		return b;
	}

	// Searching book by authorName
	@ResponseBody
	@RequestMapping("/showByAuthorName/{authorName}")
	public List<Book> showByAuthorName(@PathVariable("authorName") String authorName) {
		List<Book> b = repo.findByAuthorName(authorName);
		return b;
	}

	// Searching book by Genre
	@ResponseBody
	@RequestMapping("/showByBookGenre/{bookGenre}")
	public List<Book> showByBookGenre(@PathVariable("bookGenre") String bookGenre) {
		List<Book> b = repo.findByBookGenre(bookGenre);
		return b;
	}

	// Show By Published Date
	@ResponseBody
	@RequestMapping("/showByPublishedDate/{publishedDate}")
	public List<Book> showByPublishedDate(@PathVariable("publishedDate") Date publishedDate) {
		List<Book> b = repo.findByPublishedDate(publishedDate);
		return b;
	}

}// end class

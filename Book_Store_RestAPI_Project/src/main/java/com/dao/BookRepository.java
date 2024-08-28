package com.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Book;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Integer>{
	public Optional<Book> findByBookName(String bookName);
	public List<Book> findByAuthorName(String authorName);
	public List<Book> findByBookGenre(String bookGenre);
	//public Optional<Book> updateBook(int bookId);
	//public void findByBookName(String bookName, Book b);
	public List<Book> findByPublishedDate(Date publishedDate);
	public void deleteByBookPriceBetween(double minPrice, double maxPrice);
	//public Object updateBookById(int bookId);
	//public boolean saveOrUpdateToDoItem(Book book);
	public Optional<Book> findByBookId(int bookId);
	
	
}

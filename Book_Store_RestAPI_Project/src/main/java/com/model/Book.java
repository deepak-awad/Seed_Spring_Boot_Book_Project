package com.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//bookId, bookName, bookPrice, authorName, publishedDate, bookGenre

@Entity
@Table(name = "bookapi")
public class Book {
	@Id
	@Column(name = "bookid")
	int bookId;
	@Column(name = "bookname")
	String bookName;
	@Column(name = "bookprice")
	int bookPrice;
	@Column(name = "authorname")
	String authorName;
	@Column(name = "publisheddate")
	Date publishedDate;
	@Column(name = "bookgenre")
	String bookGenre;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookId, String bookName, int bookPrice, String authorName, Date publishedDate, String bookGenre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.authorName = authorName;
		this.publishedDate = publishedDate;
		this.bookGenre = bookGenre;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", authorName="
				+ authorName + ", publishedDate=" + publishedDate + ", bookGenre=" + bookGenre + "]";
	}
	
	
	
}

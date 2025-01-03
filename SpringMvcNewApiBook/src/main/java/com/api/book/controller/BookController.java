package com.api.book.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.entity.Book;
import com.api.book.services.BookService;

@RestController
public class BookController
{
	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return this.service.getAllBook();
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return this.service.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b = this.service.addBook(book);
		return b;
	}
	
	@DeleteMapping("/book/{id}")
	public void delBook(@PathVariable("id") int id)
	{
		this.service.delBook(122);
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id)
	{
		this.service.updateBook(book, id);
		return book;
	}
}

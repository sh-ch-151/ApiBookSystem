package com.api.book.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.book.dao.BookRepository;
import com.api.book.entity.Book;

//@Component
@Service
public class BookService
{
	@Autowired
	private BookRepository repo;
	
	public List<Book> getAllBook()
	{
		List<Book> list = (List<Book>)this.repo.findAll();
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book book = this.repo.findById(id);
		return book;
	}
	
	public Book addBook(Book b)
	{
		Book book = this.repo.save(b);
		return book;
	}
	
	public void delBook(int id)
	{
		this.repo.deleteById(id);
	}
	
	public void updateBook(Book book, int id)
	{
		this.repo.save(book);
	}
}

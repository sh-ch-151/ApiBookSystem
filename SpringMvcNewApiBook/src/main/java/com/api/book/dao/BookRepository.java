package com.api.book.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.api.book.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>
{
	public Book findById(int id);
}

package com.api.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author")
public class Author 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String fName;
	private String lName;
	private String lang;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getfName()
	{
		return fName;
	}
	
	public void setfName(String fName)
	{
		this.fName = fName;
	}
	
	public String getlName()
	{
		return lName;
	}
	
	public void setlName(String lName)
	{
		this.lName = lName;
	}
	
	public String getLang()
	{
		return lang;
	}
	
	public void setLang(String lang)
	{
		this.lang = lang;
	}
	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author(int id, String fName, String lName, String lang, Book book) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.lang = lang;
		this.book = book;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", fName=" + fName + ", lName=" + lName + ", lang=" + lang + ", book=" + book + "]";
	}
}

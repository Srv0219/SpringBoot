package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.rest.api.entities.Book;
import com.rest.api.services.BookService;

/* @Controller */
@RestController
public class Bookcontroller {
	@Autowired
	private BookService bookService;

	/* @RequestMapping(value = "/books",method = RequestMethod.GET) */
	/* @ResponseBody */
	@GetMapping("/books")
	public List<Book> getBooks() {

		return this.bookService.getAllBooks();
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) throws Exception {

		return this.bookService.getBookById(id);
	}
}
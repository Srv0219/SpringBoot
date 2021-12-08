package com.rest.api.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.rest.api.entities.Book;

@Component
public class BookService {
	private static List<Book> list = new ArrayList<>();

	static {

		list.add(new Book(1, "Springboot Using Java", "Sourav Adak"));
		list.add(new Book(2, "Springcore Using Java", "Tanmay Adak"));
		list.add(new Book(3, "Hibernate Using Java", "Vikash Adak"));
		list.add(new Book(4, "Servlet/jsp Using Java", "Prakash Adak"));

	}

	public List<Book> getAllBooks() {
		return list;
	}

	public Book getBookById(int id) throws Exception {
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;
	}

}

package com.api.book.springbootrestapi.Services;

import java.util.List;
import com.api.book.springbootrestapi.Dao.BookRepository;
import com.api.book.springbootrestapi.Entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

  @Autowired
  private BookRepository bookRepository;
  /*
   * private static List<Book> list = new ArrayList<>();
   * 
   * static {
   * 
   * list.add(new Book(1, "Springboot Using Java", "Sourav Adak"));
   * list.add(new Book(2, "Springcore Using Java", "Tanmay Adak"));
   * list.add(new Book(3, "Hibernate Using Java", "Vikash Adak"));
   * list.add(new Book(4, "Servlet/jsp Using Java", "Prakash Adak"));
   * 
   * }
   */

  public List<Book> getAllBooks() {
    // return list;
    List<Book> list = (List<Book>) this.bookRepository.findAll();
    return list;
  }

  public Book getBookById(int id) {
    Book book = null;
    // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
    book = this.bookRepository.findById(id);
    return book;
  }

  public Book addBook(Book b) {
    // list.add(b);
    Book reult = this.bookRepository.save(b);
    return reult;
  }

  public void deleteBook(int bid) {
    /*
     * list.stream().filter(book->{
     * if (book.getId()!=bid) {
     * return true;
     * }else{
     * return false;
     * }
     * }).collect(Collectors.toList());
     */

    /*
     * list = list.stream().filter(book -> book.getId() !=
     * bid).collect(Collectors.toList());
     */
    this.bookRepository.deleteById(bid);

  }

  public void updateBook(Book book, int bid) {
    /* list = list.stream().map(b -> {
      if (b.getId() == bid) {
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());

      }
      return b;
    }).collect(Collectors.toList()); */

    book.setId(bid);
    this.bookRepository.save(book);
  }
}

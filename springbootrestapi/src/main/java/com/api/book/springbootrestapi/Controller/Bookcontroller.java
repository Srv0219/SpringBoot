package com.api.book.springbootrestapi.Controller;

import java.util.List;
import java.util.Optional;

import com.api.book.springbootrestapi.Entities.Book;
import com.api.book.springbootrestapi.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* @Controller */
@RestController
public class Bookcontroller {
    @Autowired
    private BookService bookService;

    /* @RequestMapping(value = "/books",method = RequestMethod.GET) */
    /* @ResponseBody */
    // Get all books
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = this.bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     // return ResponseEntity.of(Optional.of(list));
     return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // Get single book
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) throws Exception {
        Book book = this.bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // Create new Book
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;

        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // Delete book
    @DeleteMapping("/book/{bid}")
    public ResponseEntity<Void> removeBook(@PathVariable("bid") int bid) {
        try {
            this.bookService.deleteBook(bid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update book
    @PutMapping("/book/{bid}")
    public ResponseEntity<Book> updateBook(
            @RequestBody Book book,
            @PathVariable("bid") int bid) {

        try {
            this.bookService.updateBook(book, bid);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}

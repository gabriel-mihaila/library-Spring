package com.Gabriel.project.controller;

import com.Gabriel.project.model.Book;
import com.Gabriel.project.service.BookService;
import com.Gabriel.project.service.ServiceFactory;
import com.Gabriel.project.service.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Book controller.
 */
@RestController
@RequestMapping(path = "api/book")
public class BookController {

    private final BookService bookService;


    /**
     * Instantiates a new Book controller.
     *
     * @param serviceFactory the service factory
     */
    @Autowired
    public BookController(ServiceFactory serviceFactory) {

        this.bookService = (BookService) serviceFactory.createService(ServiceType.BOOK);
    }

    /**
     * Get books list.
     *
     * @return the list
     */
    @GetMapping(path = "search")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    /**
     * Add new book book.
     *
     * @param book the book
     * @return the book
     */
    @PostMapping(path = "add")
    public Book addNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    /**
     * Delete book.
     *
     * @param bookID the book id
     */
    @DeleteMapping(path = "delete/{bookID}")
    public void deleteBook(@PathVariable("bookID") Integer bookID){
        bookService.deleteBook(bookID);
    }

    /**
     * Update book.
     *
     * @param bookID   the book id
     * @param name     the name
     * @param author   the author
     * @param quantity the quantity
     */
    @PutMapping(path = "update/{bookID}")
    public void updateBook(@PathVariable("bookID") Integer bookID, @RequestParam(required = false) String name, @RequestParam(required = false) String author, @RequestParam(required = false) Integer quantity){
        bookService.updateBook(bookID, name, author, quantity);
    }
}

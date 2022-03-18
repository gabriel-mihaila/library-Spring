package com.Gabriel.project.controller;

import com.Gabriel.project.model.Book;
import com.Gabriel.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "search")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping(path = "add")
    public Book addNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @DeleteMapping(path = "delete/{bookID}")
    public void deleteBook(@PathVariable("bookID") Integer bookID){
        bookService.deleteBook(bookID);
    }

    @PutMapping(path = "update/{bookID}")
    public void updateBook(@PathVariable("bookID") Integer bookID, @RequestParam(required = false) String name, @RequestParam(required = false) String author, @RequestParam(required = false) Integer quantity){
        bookService.updateBook(bookID, name, author, quantity);
    }
}

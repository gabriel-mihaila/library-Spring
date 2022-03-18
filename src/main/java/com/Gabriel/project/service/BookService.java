package com.Gabriel.project.service;

import com.Gabriel.project.model.Book;
import com.Gabriel.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBooksByNameContainingIgnoreCase(book.getName());

        if(bookOptional.isPresent()){
            throw new IllegalStateException("Book taken");
        }

        return bookRepository.save(book);
    }

    public void deleteBook(Integer bookID) {
        boolean exists = bookRepository.existsById(bookID);
        if(!exists){
            throw new IllegalStateException("Book with id " + bookID + " does not exists");
        }
        bookRepository.deleteById(bookID);
    }

    @Transactional
    public void updateBook(Integer bookID, String name, String author, Integer quantity) {
        Book book = bookRepository.findById(bookID)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookID + " does not exists"));

        if(name != null && !book.getName().equals(name)){
            Optional<Book> bookOptional = bookRepository.findBooksByNameContainingIgnoreCase(name);

            if(bookOptional.isPresent()){
                throw new IllegalStateException("Book taken");
            }
            book.setName(name);
        }

        if(author != null && !book.getAuthor().equals(author)){
            book.setAuthor(author);
        }

        if(quantity != null && quantity > 0){
            book.setQuantity(quantity);
        }
    }
}

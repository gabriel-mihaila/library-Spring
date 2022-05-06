package com.Gabriel.project.service;

import com.Gabriel.project.repository.BookRepository;
import com.Gabriel.project.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Book service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @Autowired
    private BookService underTest;

    /**
     * Set up.
     */
    @BeforeEach
    void setUp(){
        underTest = new BookService(bookRepository);
    }

    /**
     * Gets books.
     */
    @Test
    void getBooks() {
        underTest.getBooks();
        verify(bookRepository).findAll();
    }

    /**
     * Add new book.
     */
    @Test
    void addNewBook() {
    }

    /**
     * Delete book.
     */
    @Test
    @Disabled
    void deleteBook() {
    }

    /**
     * Update book.
     */
    @Test
    @Disabled
    void updateBook() {
    }
}
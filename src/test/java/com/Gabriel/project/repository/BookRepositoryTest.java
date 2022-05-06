package com.Gabriel.project.repository;

import com.Gabriel.project.model.Book;
import com.Gabriel.project.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Book repository test.
 */
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository underTest;

    /**
     * Find books by name containing ignore case test.
     */
    @Test
    void findBooksByNameContainingIgnoreCaseTest() {
        String name = "Alba ca Zapada";
        Book book = new Book("alba ca Zapada", "Jacob Grimm", new Category("lemne"), 10);
        underTest.save(book);
        Optional<Book> exists = underTest.findBooksByNameContainingIgnoreCase(name);
        assertThat(exists).isPresent();
        underTest.delete(book);
    }
}
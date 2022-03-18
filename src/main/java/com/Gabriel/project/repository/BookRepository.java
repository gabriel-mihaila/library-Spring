package com.Gabriel.project.repository;

import com.Gabriel.project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Book repository.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Find books by name containing ignore case optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Book> findBooksByNameContainingIgnoreCase(String name);
}

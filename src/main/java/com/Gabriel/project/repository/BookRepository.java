package com.Gabriel.project.repository;

import com.Gabriel.project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findBooksByNameContainingIgnoreCase(String name);
}

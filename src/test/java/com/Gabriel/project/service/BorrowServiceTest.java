package com.Gabriel.project.service;

import com.Gabriel.project.repository.BookRepository;
import com.Gabriel.project.repository.BorrowRepository;
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
 * The type Borrow service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BorrowServiceTest {

    @Mock
    private BorrowRepository borrowRepository;
    @Mock
    private BookRepository bookRepository;
    @Autowired
    private BorrowService underTest;

    /**
     * Set up.
     */
    @BeforeEach
    void setUp(){
        underTest = new BorrowService(borrowRepository, bookRepository);
    }

    /**
     * Gets borrows.
     */
    @Test
    void getBorrows() {
        underTest.getBorrows();
        verify(borrowRepository).findAll();
    }

    /**
     * Add new borrow.
     */
    @Test
    @Disabled
    void addNewBorrow() {
    }

    /**
     * Delete borrow.
     */
    @Test
    @Disabled
    void deleteBorrow() {
    }
}
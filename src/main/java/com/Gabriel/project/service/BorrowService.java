package com.Gabriel.project.service;

import com.Gabriel.project.model.Book;
import com.Gabriel.project.model.Borrow;
import com.Gabriel.project.repository.BookRepository;
import com.Gabriel.project.repository.BorrowRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Borrow service.
 */
@Service
public class BorrowService extends BasicService {
    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;

    /**
     * Instantiates a new Borrow service.
     *
     * @param borrowRepository the borrow repository
     * @param bookRepository   the book repository
     */
    public BorrowService(BorrowRepository borrowRepository, BookRepository bookRepository) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * Gets borrows.
     *
     * @return the borrows
     */
    public List<Borrow> getBorrows() {
        return borrowRepository.findAll();
    }

    /**
     * Add new borrow borrow.
     *
     * @param borrow the borrow
     * @return the borrow
     */
    @Transactional
    public Borrow addNewBorrow(Borrow borrow) {
        Book book = bookRepository.findById(borrow.getBookID().getId()).orElseThrow(()
                -> new IllegalStateException("Book with id " + borrow.getBookID().getId() + " does not exists"));
        if(book.getQuantity() < borrow.getQuantity())
            throw new IllegalStateException("Insufficiently sold");
        Integer newQuantity = book.getQuantity() - borrow.getQuantity();
        book.setQuantity(newQuantity);
        return borrowRepository.save(borrow);
    }

    /**
     * Delete borrow.
     *
     * @param borrowID the borrow id
     */
    @Transactional
    public void deleteBorrow(Integer borrowID) {
        boolean exists = borrowRepository.existsById(borrowID);
        if(!exists){
            throw new IllegalStateException("Borrow with id " + borrowID + " does not exists");
        }
        Borrow borrow = borrowRepository.getById(borrowID);
        Book book =  bookRepository.getById(borrow.getBookID().getId());
        Integer newQuantity = book.getQuantity() + borrow.getQuantity();
        book.setQuantity(newQuantity);
        borrowRepository.deleteById(borrowID);
    }
}

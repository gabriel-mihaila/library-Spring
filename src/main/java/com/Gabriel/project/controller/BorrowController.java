package com.Gabriel.project.controller;

import com.Gabriel.project.model.Borrow;
import com.Gabriel.project.service.BorrowService;
import com.Gabriel.project.service.ServiceFactory;
import com.Gabriel.project.service.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Borrow controller.
 */
@RestController
@RequestMapping(path = "api/borrow")
public class BorrowController {
    private final BorrowService borrowService;


    /**
     * Instantiates a new Borrow controller.
     *
     * @param serviceFactory the service factory
     */
    @Autowired
    public BorrowController(ServiceFactory serviceFactory) {

        this.borrowService = (BorrowService) serviceFactory.createService(ServiceType.BORROW);
    }

    /**
     * Get borrows list.
     *
     * @return the list
     */
    @GetMapping(path = "search")
    public List<Borrow> getBorrows(){
        return borrowService.getBorrows();
    }

    /**
     * Add new borrow borrow.
     *
     * @param borrow the borrow
     * @return the borrow
     */
    @PostMapping(path = "add")
    public Borrow addNewBorrow(@RequestBody Borrow borrow) {
        return borrowService.addNewBorrow(borrow);
    }

    /**
     * Delete borrow.
     *
     * @param borrowID the borrow id
     */
    @DeleteMapping(path = "delete/{borrowID}")
    public void deleteBorrow(@PathVariable("borrowID") Integer borrowID){
        borrowService.deleteBorrow(borrowID);
    }
}

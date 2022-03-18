package com.Gabriel.project.controller;

import com.Gabriel.project.model.Borrow;
import com.Gabriel.project.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/borrow")
public class BorrowController {
    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping(path = "search")
    public List<Borrow> getBorrows(){
        return borrowService.getBorrows();
    }

    @PostMapping(path = "add")
    public Borrow addNewBorrow(@RequestBody Borrow borrow) {
        return borrowService.addNewBorrow(borrow);
    }

    @DeleteMapping(path = "delete/{borrowID}")
    public void deleteBorrow(@PathVariable("borrowID") Integer borrowID){
        borrowService.deleteBorrow(borrowID);
    }
}

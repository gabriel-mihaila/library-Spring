package com.Gabriel.project.repository;

import com.Gabriel.project.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Borrow repository.
 */
@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {

}

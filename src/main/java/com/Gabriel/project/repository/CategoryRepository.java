package com.Gabriel.project.repository;

import com.Gabriel.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Category repository.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Find categories by name containing ignore case optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Category> findCategoriesByNameContainingIgnoreCase(String name);
}

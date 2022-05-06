package com.Gabriel.project.repository;

import com.Gabriel.project.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Category repository test.
 */
@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository underTest;

    /**
     * Find categories by name containing ignore case test.
     */
    @Test
    void findCategoriesByNameContainingIgnoreCaseTest() {
        String name = "comedie2";
        Category category = new Category(14, name);
        underTest.save(category);
        Optional<Category> exists = underTest.findCategoriesByNameContainingIgnoreCase(name);
        underTest.delete(category);
        assertThat(exists).isPresent();

    }
}
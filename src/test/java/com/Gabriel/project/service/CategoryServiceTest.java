package com.Gabriel.project.service;

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
 * The type Category service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService underTest;

    /**
     * Set up.
     */
    @BeforeEach
    void setUp(){
        underTest = new CategoryService(categoryRepository);
    }

    /**
     * Gets categories.
     */
    @Test
    void getCategories() {
        underTest.getCategories();
        verify(categoryRepository).findAll();
    }

    /**
     * Add new category.
     */
    @Test
    @Disabled
    void addNewCategory() {
    }

    /**
     * Delete category.
     */
    @Test
    @Disabled
    void deleteCategory() {
    }

    /**
     * Update category.
     */
    @Test
    @Disabled
    void updateCategory() {
    }
}
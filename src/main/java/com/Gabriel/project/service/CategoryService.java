package com.Gabriel.project.service;

import com.Gabriel.project.model.Category;
import com.Gabriel.project.repository.CategoryRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The type Category service.
 */
@Service
public class CategoryService extends BasicService {
    private final CategoryRepository categoryRepository;

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepository the category repository
     */
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Add new category category.
     *
     * @param category the category
     * @return the category
     */
    public Category addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findCategoriesByNameContainingIgnoreCase(category.getName());

        if(categoryOptional.isPresent()){
            throw new IllegalStateException("Category taken");
        }

       return categoryRepository.save(category);
    }

    /**
     * Delete category.
     *
     * @param categoryID the category id
     */
    public void deleteCategory(Integer categoryID) {
        boolean exists = categoryRepository.existsById(categoryID);
        if(!exists){
            throw new IllegalStateException("Category with id " + categoryID + " does not exists");
        }
        categoryRepository.deleteById(categoryID);
    }

    /**
     * Update category.
     *
     * @param categoryID the category id
     * @param name       the name
     */
    @Transactional
    public void updateCategory(Integer categoryID, String name) {
        Category category = categoryRepository.findById(categoryID)
                .orElseThrow(() -> new IllegalStateException("Category with id " + categoryID + " does not exists"));

        if(name != null && name.length() > 0 && !category.getName().equals(name)){
            Optional<Category> categoryOptional = categoryRepository.findCategoriesByNameContainingIgnoreCase(name);

            if(categoryOptional.isPresent()){
                throw new IllegalStateException("Category taken");
            }

            category.setName(name);
        }
    }
}

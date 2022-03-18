package com.Gabriel.project.service;

import com.Gabriel.project.model.Category;
import com.Gabriel.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findCategoriesByNameContainingIgnoreCase(category.getName());

        if(categoryOptional.isPresent()){
            throw new IllegalStateException("Category taken");
        }

       return categoryRepository.save(category);
    }

    public void deleteCategory(Integer categoryID) {
        boolean exists = categoryRepository.existsById(categoryID);
        if(!exists){
            throw new IllegalStateException("Category with id " + categoryID + " does not exists");
        }
        categoryRepository.deleteById(categoryID);
    }

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

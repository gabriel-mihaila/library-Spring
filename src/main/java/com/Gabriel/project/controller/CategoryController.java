package com.Gabriel.project.controller;

import com.Gabriel.project.model.Category;
import com.Gabriel.project.service.CategoryService;
import com.Gabriel.project.service.ServiceFactory;
import com.Gabriel.project.service.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Category controller.
 */
@RestController
@RequestMapping(path = "api/category")
public class CategoryController {

    private final CategoryService categoryService;


    /**
     * Instantiates a new Category controller.
     *
     * @param serviceFactory the service factory
     */
    @Autowired
    public CategoryController(ServiceFactory serviceFactory) {
        this.categoryService = (CategoryService) serviceFactory.createService(ServiceType.CATEGORY);
    }

    /**
     * Get categories list.
     *
     * @return the list
     */
    @GetMapping(path = "search")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    /**
     * Add new category category.
     *
     * @param category the category
     * @return the category
     */
    @PostMapping(path = "add")
    public Category addNewCategory(@RequestBody Category category) {
        return categoryService.addNewCategory(category);
    }

    /**
     * Delete category.
     *
     * @param categoryID the category id
     */
    @DeleteMapping(path = "delete/{categoryID}")
    public void deleteCategory(@PathVariable("categoryID") Integer categoryID) {
        categoryService.deleteCategory(categoryID);
    }

    /**
     * Update category.
     *
     * @param categoryID the category id
     * @param name       the name
     */
    @PutMapping(path = "update/{categoryID}")
    public void updateCategory(@PathVariable("categoryID") Integer categoryID, @RequestParam(required = false) String name) {
        categoryService.updateCategory(categoryID, name);
    }
}

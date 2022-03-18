package com.Gabriel.project.controller;

import com.Gabriel.project.model.Category;
import com.Gabriel.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "search")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping(path = "add")
    public Category addNewCategory(@RequestBody Category category) {
        return categoryService.addNewCategory(category);
    }

    @DeleteMapping(path = "delete/{categoryID}")
    public void deleteCategory(@PathVariable("categoryID") Integer categoryID) {
        categoryService.deleteCategory(categoryID);
    }

    @PutMapping(path = "update/{categoryID}")
    public void updateCategory(@PathVariable("categoryID") Integer categoryID, @RequestParam(required = false) String name) {
        categoryService.updateCategory(categoryID, name);
    }
}

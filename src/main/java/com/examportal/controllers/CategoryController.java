package com.examportal.controllers;

import com.examportal.model.exam.Category;
import com.examportal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    //add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }


    //get category

    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable ("categoryId") Long categoryId){
        return this.categoryService.getCategory(categoryId);
    }
    //get All Categories
    @GetMapping("/")
    public ResponseEntity<?> getAllCategroies(){
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }


    //update categori
    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category category1 = this.categoryService.updateCategory(category);
        return ResponseEntity.ok(category1);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }
}

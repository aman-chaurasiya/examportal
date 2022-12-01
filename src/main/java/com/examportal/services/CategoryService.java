package com.examportal.services;

import com.examportal.model.exam.Category;

import java.util.Optional;
import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getAllCategory();
    public Category getCategory(Long categoryId);
    public void deleteCategory(Long categoryId);

}

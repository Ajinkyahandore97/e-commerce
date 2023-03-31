package com.example.ecommerce.service;

import com.example.ecommerce.payload.CategoryDto;
import com.example.ecommerce.payload.PageableResponse;

public interface CategoryService {

    // create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto , Long categoryId);

    //delete
    void deleteCategory(Long categoryId);

    //all category
    PageableResponse<CategoryDto> getAllCategory(int pageNumber , int pageSize, String sortBy, String sortDir);

    //single category
    CategoryDto getSingleCategory(Long categoryId);

}


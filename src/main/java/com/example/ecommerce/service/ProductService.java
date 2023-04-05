package com.example.ecommerce.service;

import com.example.ecommerce.payload.PageableResponse;
import com.example.ecommerce.payload.ProductDto;

public interface ProductService {


    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto, Long productId);

    void deleteProduct(Long productId);

    PageableResponse<ProductDto> getAllProduct(int pageNumber, int pageSize, String sortBy, String sortDir);

    ProductDto getSingleProduct(Long productId);


    PageableResponse<ProductDto> searchByTitle(String title, int pageNumber, int pageSize, String sortBy, String sortDir);

    PageableResponse<ProductDto> getAllLive(int pageNumber, int pageSize, String sortBy, String sortDir);
}

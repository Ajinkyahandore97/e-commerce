package com.example.ecommerce.service;

import com.example.ecommerce.payload.PageableResponse;
import com.example.ecommerce.payload.ProductDto;

import java.util.List;

public interface ProductService {


    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto, Long productId);

    void deleteProduct(Long productId);

    PageableResponse<ProductDto> getAllProduct(int pageNumber, int pageSize, String sortBy, String sortDir);

    ProductDto getSingleProduct(Long productId);

    List<ProductDto> getAllLive();

    List<ProductDto> searchByTitle(String title);


}

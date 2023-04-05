package com.example.ecommerce.impl;

import com.example.ecommerce.cofig.AppConstant;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.helper.Helper;
import com.example.ecommerce.payload.PageableResponse;
import com.example.ecommerce.payload.ProductDto;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = this.modelMapper.map(productDto, Product.class);

        log.info("Initiating DAO Call for Create Product");

        product.setIsActive(AppConstant.YES);

        Product createProduct = this.productRepo.save(product);

        log.info("Completing DAO Call for Create Product");

        return this.modelMapper.map(createProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long productId) {

        log.info("Initiating DAO Call for update the Product data with productId {} : ", productId);

        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.PRODUCT_NOT_FOUND));

        product.setDescription(productDto.getDescription());
        product.setTitle(productDto.getTitle());
        product.setLive(productDto.getLive());
        product.setPrice(productDto.getPrice());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setQuantity(productDto.getQuantity());
        product.setLive(productDto.getLive());

        Product save = this.productRepo.save(product);

        log.info("Completing dao call for update the category data with  productId {} :", productId);

        return this.modelMapper.map(save, ProductDto.class);
    }

    @Override
    public void deleteProduct(Long productId) {

        log.info("Initiating DAO Call for Delete the Product data with productId {} : ", productId);

        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.PRODUCT_NOT_FOUND));

        product.setIsActive(AppConstant.NO);

        productRepo.save(product);

        log.info("Completing DAO Call for Delete product with productId {} ", productId);
    }

    @Override
    public PageableResponse<ProductDto> getAllProduct(int pageNumber, int pageSize, String sortBy, String sortDir) {

        log.info("Initiating DAO Call for get All Product");

        Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> page = this.productRepo.findAll(pageable);

        log.info("Completing DAO Call for get All Product  ");

        PageableResponse<ProductDto> pageableResponse1 = Helper.getPageableResponse(page, ProductDto.class);

        return pageableResponse1;
    }

    @Override
    public ProductDto getSingleProduct(Long productId) {

        log.info(" Initiating DAO Call for get Single Product with ProductId {} ", productId);

        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(AppConstant.PRODUCT_NOT_FOUND));

        log.info("Completing DAO Call for get Single Product with ProductID {} ", productId);

        return this.modelMapper.map(product, ProductDto.class);
    }

    @Override
    public PageableResponse<ProductDto> searchByTitle(String title, int pageNumber, int pageSize, String sortBy, String sortDir) {

        log.info("Initiating DAO Call for get All Product");

        Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> allByTitleContaining = this.productRepo.findAllByTitleContaining(title, pageable);

        log.info("Completing DAO Call for get All Product");

        PageableResponse<ProductDto> pageableResponse = Helper.getPageableResponse(allByTitleContaining, ProductDto.class);

        return pageableResponse;
    }

    @Override
    public PageableResponse<ProductDto> getAllLive(int pageNumber, int pageSize, String sortBy, String sortDir) {

        log.info("Initiating DAO Call for get Product");

        Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> byLiveTrue = this.productRepo.findByLiveTrue(pageable);

        log.info("Completing DAO Call for get All Product  ");

        PageableResponse<ProductDto> pageableResponse1 = Helper.getPageableResponse(byLiveTrue, ProductDto.class);

        return pageableResponse1;
    }


}

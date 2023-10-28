package com.learn.app.service;

import com.learn.app.dto.ProductDto;
import com.learn.app.dto.ProductSummary;
import com.learn.app.model.ProductDocument;

public interface ProductService {

  ProductDto getProduct(String productId);

  ProductSummary getProducts();

  String saveProduct(ProductDto productDto);
}

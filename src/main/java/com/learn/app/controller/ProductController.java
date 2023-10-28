package com.learn.app.controller;

import com.learn.app.dto.ProductDto;
import com.learn.app.dto.ProductSummary;
import com.learn.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

  @Autowired private ProductService productService;

  @GetMapping("product/{product-id}")
  public ResponseEntity<ProductDto> productDetails(@PathVariable("product-id") String productId) {

    return ResponseEntity.ok(productService.getProduct(productId));
  }

  @GetMapping("products")
  public ResponseEntity<ProductSummary> productDetails() {

    return ResponseEntity.ok(productService.getProducts());
  }

  @PostMapping("product")
  public ResponseEntity<String> saveProduct(@RequestBody ProductDto product) {

    return ResponseEntity.ok(productService.saveProduct(product));
  }
}

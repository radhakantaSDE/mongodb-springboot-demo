package com.learn.app.service;

import com.learn.app.dto.ProductDto;
import com.learn.app.dto.ProductSummary;
import com.learn.app.model.ProductDocument;
import com.learn.app.repository.ProductRepository;
import com.learn.app.util.ModelMapper;
import com.learn.app.util.UUIDGenerator;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  /**
   * Helps to retrieve product documents from DB
   *
   * @param productId product id for which db search will occure
   */
  @Override
  public ProductDto getProduct(@NonNull String productId) {
    ProductDocument productDocument = productRepository.findById(productId).orElse(null);
    return productDocument != null ? ModelMapper.toProductDto(productDocument) : null;
  }

  /** Helps to retrieve all products of a customer */
  @Override
  public ProductSummary getProducts() {

    List<ProductDocument> productDocuments = productRepository.findAll();
    return ProductSummary.builder()
        .products(productDocuments.stream().map(ModelMapper::toProductDto).toList())
        .build();
  }

  /**
   * Helps to save product documents in DB
   *
   * @param productDto product dao
   */
  @Override
  public String saveProduct(@NonNull ProductDto productDto) {

    ProductDocument productDocument = ModelMapper.toProductDocument(productDto);
    productDocument.setId(UUIDGenerator.randomUUID());
    ProductDocument newProductDocument = productRepository.save(productDocument);
    return newProductDocument.getId() != null ? "Product Saved Successfully" : "Failed to save !!!";
  }
}

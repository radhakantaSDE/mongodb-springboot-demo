package com.learn.app.util;

import com.learn.app.dto.ProductDto;
import com.learn.app.model.ProductDocument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/** Keeps converter utils */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelMapper {

  /**
   * Helps to convert ProductDto to ProductDocument
   *
   * @param productDto product dto object
   */
  public static ProductDocument toProductDocument(@NonNull ProductDto productDto) {

    return ProductDocument.builder()
        .name(productDto.getName())
        .price(productDto.getPrice())
        .publishedYear(productDto.getPublishedYear())
        .build();
  }

  /**
   * Helps to convert ProductDocument to ProductDto
   *
   * @param productDocument product document object
   */
  public static ProductDto toProductDto(@NonNull ProductDocument productDocument) {
    return ProductDto.builder()
        .id(productDocument.getId())
        .name(productDocument.getName())
        .price(productDocument.getPrice())
        .publishedYear(productDocument.getPublishedYear())
        .build();
  }
}

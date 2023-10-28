package com.learn.app.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ProductSummary implements Serializable {

  private List<ProductDto> products;
}

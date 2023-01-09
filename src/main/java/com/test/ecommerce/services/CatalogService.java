package com.test.ecommerce.services;

import com.test.ecommerce.models.*;

import java.util.*;

public interface CatalogService {

  public Optional<Category> findCategoryById(Long id);
  public List<Category> findAllCategories();
  public Optional<Product> findProductById(Long id);
  public List<Product> findAllProducts();
}

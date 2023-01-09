package com.test.ecommerce.services;

import com.test.ecommerce.models.*;
import com.test.ecommerce.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Optional<Category> findCategoryById(Long id) {
    return categoryRepository.findById(id);
  }

  @Override
  public List<Category> findAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public Optional<Product> findProductById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }
}

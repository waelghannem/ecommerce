package com.test.ecommerce.repositories;

import com.test.ecommerce.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

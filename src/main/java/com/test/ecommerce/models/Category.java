package com.test.ecommerce.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.*;

@Table(name = "category")
@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "category_id", nullable = false)
  private Long id;


  @ManyToOne
  @JoinColumn(name="parent_id")
  private Category category;

  @OneToMany(mappedBy="category", cascade = CascadeType.ALL)
  private Set<Category> categories = new HashSet<Category>();
  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<Product> products = new ArrayList<>();
  private String name;
  private String description;
}

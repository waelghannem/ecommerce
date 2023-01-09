package com.test.ecommerce.dto;

import com.test.ecommerce.models.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ShoppingBasketItem {

  private final int quantity;
  private final Product product;

  private final Category category;

  public ShoppingBasketItem(Product product, int quantity, Category category) {
    this.product = product;
    this.quantity = quantity;
    this.category = category;
  }

  public BigDecimal totalPrice() {
    return BigDecimal.valueOf(quantity * product.getPrice()
        .precision());
  }

  public int quantity() {
    return quantity;
  }


  @Override
  public String toString() {
    return "ShoppingBasketItem{" +
        "product=" + product +
        ", quantity=" + quantity +
        '}';
  }
}

package com.test.ecommerce.dto;

import com.test.ecommerce.models.UserID;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class ShoppingBasket {
  private final UserID userID;
  private final LocalDate creationDate;
  private List<ShoppingBasketItem> items = new ArrayList<>();

  public UserID userId() {
    return userID;
  }

  public void add(ShoppingBasketItem item) {
    items.add(item);
  }

  public BigDecimal total() {
    return BigDecimal.valueOf(items.stream()
        .map(item -> item.totalPrice().doubleValue())
        .reduce((t, acc) -> acc + t).orElse(0.0));
  }


  @Override
  public String toString() {
    return "ShoppingBasket{" +
        ", creationDate=" + creationDate +
        ", items=" + items +
        '}';
  }
}

package com.test.ecommerce.repositories;

import com.test.ecommerce.dto.ShoppingBasket;
import com.test.ecommerce.models.UserID;

import java.time.LocalDate;
import java.util.*;

public class ShoppingBasketRepository {
  private Map<UserID, ShoppingBasket> baskets = new HashMap<>();


  public ShoppingBasket basketFor(UserID userId) {
    return baskets.getOrDefault(userId, createBasket(userId));
  }

  public void save(ShoppingBasket basket) {
    baskets.put(basket.userId(), basket);
  }

  private ShoppingBasket createBasket(UserID userID) {
    return new ShoppingBasket(userID, LocalDate.now(), new ArrayList<>());
  }
}

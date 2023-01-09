package com.test.ecommerce.services;

import com.test.ecommerce.dto.*;
import com.test.ecommerce.models.*;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

  public void addProductToBasket(Long productID, int quantity, Category category, ShoppingBasket basket);
  public BigDecimal getTotal(ShoppingBasket basket);

  public void addProductsToBasket(List<ShoppingBasketItem> shoppingBasketItems, ShoppingBasket basket);

  public void createNewBasket(UserID userID);
}

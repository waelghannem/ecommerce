package com.test.ecommerce.controllers;

import com.test.ecommerce.dto.*;
import com.test.ecommerce.models.*;
import com.test.ecommerce.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(Urls.BASE_PATH)
@CrossOrigin(origins = "*")
@ControllerAdvice
public class CatalogController {

  @Autowired
  private CatalogService catalogService;

  @Autowired
  private OrderService orderService;


  @PostMapping( value = Urls.CREATE_BASKET, consumes = { "application/json" })
  public void createNewBasket(UserID userID) {
    orderService.createNewBasket(userID);
  }

  @PostMapping( value = Urls.GET_TOTAL, consumes = { "application/json" })
  public BigDecimal getTotal(ShoppingBasket shoppingBasket) {
    return orderService.getTotal(shoppingBasket);
  }

  @PostMapping( value = Urls.ADD_PRODUCT, consumes = { "application/json" })
  public void addProductToShoppingBasket(Long productID, int quantity, Category category, ShoppingBasket basket) {
    orderService.addProductToBasket(productID, quantity, category, basket);
  }

  @PostMapping( value = Urls.ADD_PRODUCTS, consumes = { "application/json" })
  public void addProductsToShoppingBasket(List<ShoppingBasketItem> shoppingBasketItems, ShoppingBasket basket) {
    orderService.addProductsToBasket(shoppingBasketItems, basket);
  }
}

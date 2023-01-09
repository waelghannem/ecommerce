package com.test.ecommerce.services;

import com.test.ecommerce.dto.*;
import com.test.ecommerce.models.*;
import com.test.ecommerce.repositories.ShoppingBasketRepository;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderServiceImpl implements OrderService {


  private CatalogService catalogService;
  private ShoppingBasketRepository shoppingBasketRepository;


  public void addProductToBasket(Long productID, int quantity, Category category, ShoppingBasket basket) {
    Optional<Product> product = catalogService.findProductById(productID);
    if(product.isPresent()) {
      basket.add(new ShoppingBasketItem(product.get(), quantity, category));
      shoppingBasketRepository.save(basket);
    }
  }

  public BigDecimal getTotal(ShoppingBasket basket) {
    return basket.total();
  }

  public void addProductsToBasket(List<ShoppingBasketItem> shoppingBasketItems, ShoppingBasket basket) {
    shoppingBasketItems.forEach(shoppingBasketItem -> {
      addProductToBasket(shoppingBasketItem.getProduct()
          .getId(), shoppingBasketItem.getQuantity(), shoppingBasketItem.getCategory(), basket);
    });
  }

  @Override
  public void createNewBasket(UserID userID) {
    shoppingBasketRepository.basketFor(userID);
  }
}

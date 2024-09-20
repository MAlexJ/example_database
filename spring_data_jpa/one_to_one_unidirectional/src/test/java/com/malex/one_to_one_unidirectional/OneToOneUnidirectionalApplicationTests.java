package com.malex.one_to_one_unidirectional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.malex.one_to_one_unidirectional.entity.Product;
import com.malex.one_to_one_unidirectional.entity.Stock;
import com.malex.one_to_one_unidirectional.entity.StockStatus;
import com.malex.one_to_one_unidirectional.repository.ProductRepository;
import com.malex.one_to_one_unidirectional.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToOneUnidirectionalApplicationTests {

  @Autowired private ProductRepository productRepository;

  @Autowired private StockRepository stockRepository;

  @Test
  void contextLoads() {}

  @Test
  void createProductWithStock() {

    // create product and stock
    var stock = createStock(1, StockStatus.IN_STOCK);
    var product = createProduct("Phone", 24, stock);

    // save product with stock
    var persistProduct = productRepository.save(product);

    // then
    assertNotNull(persistProduct);

    // and product has stock
    assertNotNull(persistProduct.getStock());
    assertEquals(persistProduct.getStock().getStockQuantity(), 1);
  }

  @Test
  void testStock() {
    // create product and stock
    var stock = createStock(2, StockStatus.OUT_OF_STOCK);
    var product = createProduct("Macbook", 1000, stock);

    // save product with stock
    var persistProduct = productRepository.save(product);
    assertNotNull(persistProduct);

    // find stock
    var persistStock = stockRepository.findAll().stream().findFirst().orElseThrow();

    // then
    assertNotNull(persistStock);
    assertEquals(persistStock.getStockQuantity(), 2);
    assertEquals(persistStock.getStockStatus(), StockStatus.OUT_OF_STOCK);
  }

  private Stock createStock(int quantity, StockStatus status) {
    Stock stock = new Stock();
    stock.setStockQuantity(quantity);
    stock.setStockStatus(status);
    return stock;
  }

  private Product createProduct(String name, int price, Stock stock) {
    Product product = new Product();
    product.setProductName(name);
    product.setProductPrice(price);
    product.setStock(stock);
    return product;
  }
}

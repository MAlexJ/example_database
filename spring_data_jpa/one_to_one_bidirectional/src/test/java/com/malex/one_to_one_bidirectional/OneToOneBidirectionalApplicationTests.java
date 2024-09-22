package com.malex.one_to_one_bidirectional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.malex.one_to_one_bidirectional.entity.Product;
import com.malex.one_to_one_bidirectional.entity.Stock;
import com.malex.one_to_one_bidirectional.entity.StockStatus;
import com.malex.one_to_one_bidirectional.repository.ProductRepository;
import com.malex.one_to_one_bidirectional.repository.StockRepository;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToOneBidirectionalApplicationTests {
  Logger logger = Logger.getLogger(OneToOneBidirectionalApplicationTests.class.getName());

  @Autowired private ProductRepository productRepository;

  @Autowired private StockRepository stockRepository;

  @Test
  void createProductWithStock() {

    Stock stock = Stock.builder().stockStatus(StockStatus.IN_STOCK).stockQuantity(3).build();

    Product apple = Product.builder().productName("Apple").productPrice(1000).stock(stock).build();

    /*
     * SQL: save product with stock
     * Hibernate: insert into stock (stock_quantity,stock_status,stock_id) values (?,?,default)
     * Hibernate: insert into product (product_name,product_price,stock_id,product_id) values (?,?,?,default)
     */
    Product persistProduct = productRepository.save(apple);

    // test unidirectional
    assertNotNull(persistProduct);
    assertNotNull(persistProduct.getStock());

    var stockId = persistProduct.getStock().getId();
    logger.info("Find stock by id: " + stockId);

    /*
     * SQL: findById
     * select s1_0.stock_id,p1_0.product_id,p1_0.product_name,p1_0.product_price,s1_0.stock_quantity,s1_0.stock_status
     *   from stock s1_0
     *   left join product p1_0 on s1_0.stock_id=p1_0.stock_id
     *   where s1_0.stock_id=?
     */
    Stock persistStock = stockRepository.findById(stockId).orElseThrow();
    assertNotNull(persistStock);
    assertNotNull(persistStock.getProduct());
  }

  @Test
  void findAllStocks() {
    Stock appleStock = Stock.builder().stockStatus(StockStatus.IN_STOCK).stockQuantity(3).build();
    Stock macStock = Stock.builder().stockStatus(StockStatus.IN_STOCK).stockQuantity(3).build();
    Stock samsungStock = Stock.builder().stockStatus(StockStatus.IN_STOCK).stockQuantity(3).build();

    Product apple =
        Product.builder().productName("Apple").productPrice(1000).stock(appleStock).build();
    Product mac = Product.builder().productName("Mac").productPrice(1000).stock(macStock).build();
    Product samsung =
        Product.builder().productName("Samsung").productPrice(1000).stock(samsungStock).build();

    /*
     * SQL: save product with stock
     * Hibernate: insert into stock (stock_quantity,stock_status,stock_id) values (?,?,default)
     * Hibernate: insert into product (product_name,product_price,stock_id,product_id) values (?,?,?,default)
     */
    productRepository.saveAll(List.of(apple, mac, samsung));

    logger.info("Find stock all");
    /*
     * SQL:  findALl => N+1
     * Hibernate:
     * select s1_0.stock_id,s1_0.stock_quantity,s1_0.stock_status
     *    from stock s1_0
     * Hibernate:
     * select p1_0.product_id,p1_0.product_name,p1_0.product_price,
     *            s1_0.stock_id,s1_0.stock_quantity,s1_0.stock_status
     *    from product p1_0
     *    left join stock s1_0 on s1_0.stock_id=p1_0.stock_id
     *    where p1_0.stock_id=?
     * Hibernate: select p1_0.product_id,p1_0.product_name,p1_0.product_price,s1_0.stock_id,s1_0.stock_quantity,s1_0.stock_status
     *    from product p1_0 left join stock s1_0 on s1_0.stock_id=p1_0.stock_id where p1_0.stock_id=?
     * Hibernate: select p1_0.product_id,p1_0.product_name,p1_0.product_price,s1_0.stock_id,s1_0.stock_quantity,s1_0.stock_status
     *    from product p1_0 left join stock s1_0 on s1_0.stock_id=p1_0.stock_id where p1_0.stock_id=?
     */
    List<Stock> all = stockRepository.findAll();
    logger.info("Stocks " + all);
  }
}

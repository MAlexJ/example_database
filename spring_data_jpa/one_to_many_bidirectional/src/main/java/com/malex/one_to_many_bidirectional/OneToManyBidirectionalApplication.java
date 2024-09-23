package com.malex.one_to_many_bidirectional;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyBidirectionalApplication {

  @SneakyThrows
  public static void main(String[] args) {
    SpringApplication.run(OneToManyBidirectionalApplication.class, args);
    TimeUnit.SECONDS.sleep(10);
  }
}

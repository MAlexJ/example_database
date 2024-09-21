package com.malex.one_to_one_bidirectional;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneBidirectionalApplication {

  @SneakyThrows
  public static void main(String[] args) {
    SpringApplication.run(OneToOneBidirectionalApplication.class, args);
    TimeUnit.SECONDS.sleep(10);
  }
}

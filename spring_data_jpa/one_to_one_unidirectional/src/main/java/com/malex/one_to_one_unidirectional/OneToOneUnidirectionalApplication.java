package com.malex.one_to_one_unidirectional;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneUnidirectionalApplication {

  @SneakyThrows
  public static void main(String[] args) {
    SpringApplication.run(OneToOneUnidirectionalApplication.class, args);
    TimeUnit.SECONDS.sleep(10);
  }
}

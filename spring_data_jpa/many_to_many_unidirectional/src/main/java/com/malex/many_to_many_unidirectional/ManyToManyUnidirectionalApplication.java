package com.malex.many_to_many_unidirectional;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyUnidirectionalApplication {

  @SneakyThrows
  public static void main(String[] args) {
    SpringApplication.run(ManyToManyUnidirectionalApplication.class, args);
    TimeUnit.SECONDS.sleep(15);
  }
}

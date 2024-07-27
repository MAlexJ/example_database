package com.malex.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.malex.SpringDataMongoBdApplication;
import com.malex.entity.UserEntity;
import java.util.Optional;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * test info:
 * https://stackoverflow.com/questions/76689139/embedded-mongo-migration-from-spring-boot-2-7-to-3-1-1
 *
 * <p>lijk: https://bootcamptoprod.com/embedded-mongodb-spring-boot-guide/
 */
@ActiveProfiles("test")
@DataMongoTest()
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringDataMongoBdApplication.class)
class UserRepositoryTest {

  @Autowired private UserRepository userRepository;

  @Autowired private MongoTemplate mongoTemplate;

  @Order(1)
  @Test
  void testDb() {
    assertThat(mongoTemplate.getDb()).isNotNull();
  }

  @Order(2)
  @Test
  void test() {
    // 1. save user to db
    UserEntity entity = buildUser();
    UserEntity persistEntity = userRepository.save(entity);

    // find user in db
    Optional<UserEntity> userEntityOpt = userRepository.findById(persistEntity.getId());
    assertThat(userEntityOpt.isPresent()).isTrue();

    // 3. verify user
    assertThat(userEntityOpt.get()).isEqualTo(entity);
  }

  private UserEntity buildUser() {
    UserEntity entity = new UserEntity();
    entity.setUsername("max");
    return entity;
  }
}

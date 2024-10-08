package com.malex.one_to_many_unidirectional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.malex.one_to_many_unidirectional.entity.oneToMany_joinColumn.DetailEntity;
import com.malex.one_to_many_unidirectional.entity.oneToMany_joinColumn.ItemEntity;
import com.malex.one_to_many_unidirectional.repository.oneToMany_joinColumn.DetailRepository;
import com.malex.one_to_many_unidirectional.repository.oneToMany_joinColumn.ItemRepository;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class OneToManyUnidirectional_JoinColumn_Tests {

  @Autowired private ItemRepository itemRepository;

  @Autowired private DetailRepository detailRepository;

  @Test
  void createDetailsThenItem() {
    var localDateTime = LocalDateTime.now();

    var firstDetail = new DetailEntity();
    firstDetail.setInformation("First Detail, time: " + localDateTime);

    var secondDetail = new DetailEntity();
    secondDetail.setInformation("Second Detail, time: " + localDateTime);

    var detailEntities = detailRepository.saveAll(List.of(firstDetail, secondDetail));

    var item = new ItemEntity();
    item.setDescription("Item One, time: " + localDateTime);
    item.setDetails(new HashSet<>(detailEntities));

    ItemEntity itemEntity = itemRepository.save(item);
    assertNotNull(itemEntity);
    assertNotNull(itemEntity.getId());

    ItemEntity firstItem = itemRepository.findAll().stream().findFirst().orElseThrow();
    assertNotNull(firstItem);
    assertEquals(firstItem.getDetails().size(), 2);
  }

  @Test
  void createItemThenDetail() {

    // create and save item
    var item = new ItemEntity();
    item.setDescription("Item One");
    Long itemId = itemRepository.save(item).getId();

    // create and save details
    var firstDetail = new DetailEntity();
    firstDetail.setInformation("First Detail");
    firstDetail.setItemId(itemId);

    var secondDetail = new DetailEntity();
    secondDetail.setInformation("Second Detail");
    secondDetail.setItemId(itemId);
    detailRepository.saveAll(List.of(firstDetail, secondDetail));


    ItemEntity itemWithDetailsByItemId = itemRepository.findItemWithDetailsByItemId(itemId);

    System.out.println(itemWithDetailsByItemId.getDetails().size());
  }
}

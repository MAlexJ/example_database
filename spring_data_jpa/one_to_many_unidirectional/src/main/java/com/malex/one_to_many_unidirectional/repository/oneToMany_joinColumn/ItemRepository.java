package com.malex.one_to_many_unidirectional.repository.oneToMany_joinColumn;

import com.malex.one_to_many_unidirectional.entity.oneToMany_joinColumn.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findItemWithDetailsByItemId(Long itemId);

}

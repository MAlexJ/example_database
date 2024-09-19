package com.malex.one_to_many_unidirectional.repository.oneToMany_joinColumn;

import com.malex.one_to_many_unidirectional.entity.oneToMany_joinColumn.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<DetailEntity, Long> {}

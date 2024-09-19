package com.malex.one_to_many_unidirectional.repository.oneToMany;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.one_to_many_unidirectional.entity.oneToMany.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {}

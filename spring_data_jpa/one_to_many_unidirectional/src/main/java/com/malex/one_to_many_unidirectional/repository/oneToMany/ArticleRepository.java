package com.malex.one_to_many_unidirectional.repository.oneToMany;

import com.malex.one_to_many_unidirectional.entity.oneToMany.ArticleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

  ArticleEntity findArticleById(Long id);

  ArticleEntity findArticleWithCommentsByArticleId(Long id);
}

package com.malex.one_to_many_unidirectional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.malex.one_to_many_unidirectional.entity.oneToMany.ArticleEntity;
import com.malex.one_to_many_unidirectional.entity.oneToMany.CommentEntity;
import com.malex.one_to_many_unidirectional.repository.oneToMany.ArticleRepository;
import com.malex.one_to_many_unidirectional.repository.oneToMany.CommentRepository;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class OneToManyUnidirectionalTests {

  @Autowired private ArticleRepository articleRepository;

  @Autowired private CommentRepository commentRepository;

  @Test
  void oneToManyUnidirectional() {

    // given
    var firstComment = new CommentEntity();
    firstComment.setDescription("First comment");
    firstComment.setDate(LocalDateTime.now().minusDays(1));

    // given
    var secondComment = new CommentEntity();
    secondComment.setDescription("First comment");
    secondComment.setDate(LocalDateTime.now().minusDays(1));

    // and
    var commentEntities = commentRepository.saveAll(List.of(firstComment, secondComment));

    var article = new ArticleEntity();
    article.setComments(new HashSet<>(commentEntities));
    article.setName("Article");

    // when
    ArticleEntity articleEntity = articleRepository.save(article);

    // then
    assertNotNull(articleEntity);

    // and
    ArticleEntity firstArticle = articleRepository.findAll().stream().findFirst().orElseThrow();
    assertNotNull(firstArticle);
    assertEquals(firstArticle.getComments().size(), 2);
  }
}

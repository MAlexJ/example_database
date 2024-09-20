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
  void createCommentThenArticle() {

    // create first comment
    var firstComment = buildComment("First comment");

    // create second comment
    var secondComment = buildComment("Second comment");

    // save comments
    var comments = commentRepository.saveAll(List.of(firstComment, secondComment));

    // create article
    var article = buildArticle(comments);

    // save article
    var articleEntity = articleRepository.save(article);

    // then
    assertNotNull(articleEntity);

    // and
    var firstArticle = articleRepository.findAll().stream().findFirst().orElseThrow();
    assertNotNull(firstArticle);
    assertEquals(firstArticle.getComments().size(), 2);
  }

  @Test
  void createArticleThenComment() {

    // create article and save
    var article = buildArticle();
    var articleEntity = articleRepository.save(article);
    Long articleId = articleEntity.getId();
    assertNotNull(articleEntity);

    // create first comment
    var firstComment = buildComment("First comment", articleId);

    // create second comment
    var secondComment = buildComment("Second comment", articleId);

    // save comments
    var commentEntities = commentRepository.saveAll(List.of(firstComment, secondComment));

    ArticleEntity persistArticle = articleRepository.findArticleById(articleId);
    assertNotNull(persistArticle);

    persistArticle = articleRepository.findArticleWithCommentsByArticleId(articleId);
    assertNotNull(persistArticle);

    // todo: note no comments!
    assertEquals(persistArticle.getComments().size(), 0);
  }

  private ArticleEntity buildArticle(List<CommentEntity> comments) {
    var article = buildArticle();
    article.setComments(new HashSet<>(comments));
    return article;
  }

  private ArticleEntity buildArticle() {
    var article = new ArticleEntity();
    article.setName("Article");
    return article;
  }

  private CommentEntity buildComment(String description, Long articleId) {
    var comment = buildComment(description);
    comment.setDate(LocalDateTime.now().plusDays(description.length()));
    return comment;
  }

  private CommentEntity buildComment(String description) {
    var comment = new CommentEntity();
    comment.setDescription(description);
    comment.setDate(LocalDateTime.now().plusDays(description.length()));
    return comment;
  }
}

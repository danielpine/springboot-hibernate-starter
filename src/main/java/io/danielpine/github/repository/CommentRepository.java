package io.danielpine.github.repository;


import io.danielpine.github.entity.Comment;
import io.danielpine.github.entity.Son;
import io.danielpine.github.projection.InlineComment;
import io.danielpine.github.projection.InlineFather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = InlineComment.class)
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @RestResource(path = "serach", rel = "articleIdAndCommentType")
    List<Comment> findByArticleIdAndCommentType(@Param("articleId") Long articleId, @Param("commentType") String commentType);
}

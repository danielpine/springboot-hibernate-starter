package io.danielpine.github.projection;

import io.danielpine.github.entity.Comment;
import io.danielpine.github.entity.Son;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.Set;

@Projection(name = "inlineComment", types = {Comment.class})
public interface InlineComment {

    Long getId();

    Long getArticleId();

    String getUser();

    String getToUser();

    String getContent();

    String getCommentType();

    Date getCreateTime();

    Set<Comment> getSub();
}

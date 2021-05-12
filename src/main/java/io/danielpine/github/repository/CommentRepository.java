package io.danielpine.github.repository;


import io.danielpine.github.entity.Comment;
import io.danielpine.github.entity.Son;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}

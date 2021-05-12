package io.danielpine.github.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private Long articleId;

    private Long commentFromUid;

    private Long commentToUid;

    private String content;

    @ManyToOne
    @JsonIgnore
    private Comment root;

    @OneToMany(mappedBy = "root", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Comment> sub;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentFromUid() {
        return commentFromUid;
    }

    public void setCommentFromUid(Long commentFromUid) {
        this.commentFromUid = commentFromUid;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCommentToUid() {
        return commentToUid;
    }

    public void setCommentToUid(Long commentToUid) {
        this.commentToUid = commentToUid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment getRoot() {
        return root;
    }

    public void setRoot(Comment root) {
        this.root = root;
    }

    public List<Comment> getSub() {
        return sub;
    }

    public void setSub(List<Comment> sub) {
        this.sub = sub;
    }
}

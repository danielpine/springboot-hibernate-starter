package io.danielpine.github.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Father {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "father", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Son> son;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Son> getSon() {
        return son;
    }

    public void setSon(Set<Son> son) {
        this.son = son;
    }
}

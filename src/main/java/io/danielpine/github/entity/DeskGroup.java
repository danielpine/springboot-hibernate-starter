package io.danielpine.github.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

@Entity
@NamedEntityGraph(name = "desk.teller", attributeNodes = {
	@NamedAttributeNode(value = "desk"),
})

public class DeskGroup {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Desk> desk;

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

    public List<Desk> getDesk() {
	return desk;
    }

    public void setDesk(List<Desk> desk) {
	this.desk = desk;
    }

}

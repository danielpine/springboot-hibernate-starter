package io.danielpine.github.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

@Entity
@NamedEntityGraph(name = "teller", attributeNodes = { @NamedAttributeNode("teller") })
public class Desk {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private DeskGroup group;

    @OneToMany(mappedBy = "desk", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Teller> teller;

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

    public DeskGroup getGroup() {
	return group;
    }

    public void setGroup(DeskGroup group) {
	this.group = group;
    }

    public List<Teller> getTeller() {
	return teller;
    }

    public void setTeller(List<Teller> teller) {
	this.teller = teller;
    }

}

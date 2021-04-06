package io.danielpine.github.spring;

public class TestBean {
    private String name = "Danielpine";

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "TestBean [name=" + name + "]";
    }

}

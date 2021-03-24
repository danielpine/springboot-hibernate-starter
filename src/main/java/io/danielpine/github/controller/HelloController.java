package io.danielpine.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.danielpine.github.entity.DeskGroup;
import io.danielpine.github.repository.DeskGroupRepository;

@RestController
public class HelloController {

	@Autowired
	private DeskGroupRepository deskGroupRepository;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello Hibenate!";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<DeskGroup> all() {
		List<DeskGroup> findAll = deskGroupRepository.findAll();
		return findAll;
	}
}

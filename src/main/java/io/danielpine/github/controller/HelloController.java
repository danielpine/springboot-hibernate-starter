package io.danielpine.github.controller;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.danielpine.github.entity.DeskGroup;
import io.danielpine.github.repository.DeskGroupRepository;

@RestController
public class HelloController {
    private final static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DeskGroupRepository deskGroupRepository;
    @Autowired
    private Executor taskExecutor;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("this is info log");
        log.error("this is error log");
        log.warn("this is warn log");
        hi();
        return "Hello Hibenate!";
    }

    public String hi() {
        log.info("this is hi()");
        IntStream.range(0, 10).forEach(i -> {
            taskExecutor.execute(() -> {
                log.info("this is trace log {}", i);
            });
        });
        return "Hello Hibenate!";
    }

    @RequestMapping("/user/{username}")
    @ResponseBody
    public String getUerBlog(@PathVariable String username) {
        return "user: " + username;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DeskGroup> all() {
        List<DeskGroup> findAll = deskGroupRepository.findAll();
        return findAll;
    }
}

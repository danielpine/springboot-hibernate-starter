package io.danielpine.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import io.danielpine.github.entity.Desk;
import io.danielpine.github.entity.DeskGroup;
import io.danielpine.github.entity.Teller;
import io.danielpine.github.repository.DeskGroupRepository;
import io.danielpine.github.repository.DeskRepository;
import io.danielpine.github.repository.TellerRepository;

@SpringBootApplication
public class HibernateOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneApplication.class, args);
	}

}

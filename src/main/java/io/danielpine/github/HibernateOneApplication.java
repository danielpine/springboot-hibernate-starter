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

//@Component
class InitCommandLineRunner implements CommandLineRunner {

	@Autowired
	private DeskGroupRepository deskGroupRepository;
	@Autowired
	private DeskRepository deskRepository;
	@Autowired
	private TellerRepository tellerRepository;

	@Override
	public void run(String... args) throws Exception {
		DeskGroup deskGroup = new DeskGroup();
		deskGroup.setId(1L);
		deskGroup.setName("group_name_" + 1);
		DeskGroup save = deskGroupRepository.save(deskGroup);
		Desk desk = new Desk();
		desk.setGroup(save);
		desk.setId(2L);
		desk.setName("desk_name_" + 2);
		Desk save2 = deskRepository.save(desk);
		Teller teller = new Teller();
		teller.setDesk(save2);
		teller.setId(3L);
		teller.setName("teller_name_" + 3);
		tellerRepository.save(teller);
		System.out.println("calling -> InitCommandLineRunner");
	}
}

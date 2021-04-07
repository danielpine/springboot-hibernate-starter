package io.danielpine.github;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.danielpine.github.entity.Desk;
import io.danielpine.github.entity.DeskGroup;
import io.danielpine.github.entity.Teller;
import io.danielpine.github.repository.DeskGroupRepository;
import io.danielpine.github.repository.DeskRepository;
import io.danielpine.github.repository.TellerRepository;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeskGroupRepositoryTests {

    @Autowired
    private DeskGroupRepository deskGroupRepository;

    @Test
    void test() {
	Optional<DeskGroup> findById = deskGroupRepository.findById(1L);
	DeskGroup deskGroup = findById.get();
	System.out.println("Task:: " + deskGroup);

    }

    @Test
    void testall() {
	List<DeskGroup> list = deskGroupRepository.findAllWithEG();
	System.out.println(list);
    }

    @Test
    void testOne() {
	try {
	    DeskGroup g = deskGroupRepository.findOneById(1L);
	    System.out.println(g);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}

@Component
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

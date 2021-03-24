package io.danielpine.github;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.danielpine.github.entity.DeskGroup;
import io.danielpine.github.repository.DeskGroupRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeskGroupRepositoryTests {

	@Autowired
	private DeskGroupRepository deskGroupRepository;

	@Test
	void test() {
//		List<DeskGroup> findAll = deskGroupRepository.findAll();
		Optional<DeskGroup> findById = deskGroupRepository.findById(15L);
		DeskGroup deskGroup = findById.get();
		System.out.println("Task:: " + deskGroup);
	}

}

package io.danielpine.github;

import io.danielpine.github.entity.DeskGroup;
import io.danielpine.github.repository.DeskGroupRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    void testPattern() {
        String source = "ABCE112E01F02";
        Pattern compile = Pattern.compile("[EF]{1}\\d{2}(?!\\d) ");
        Matcher matcher = compile.matcher(source);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
//	
//	Collections.synchronizedMap(m)
////	Collections.synchronizedList(list)
////	
//	ConcurrentSkipListMap<K, V>
//	ConcurrentHashMap<K, V>
//	
////	Hashtable<K, V>
    }

}

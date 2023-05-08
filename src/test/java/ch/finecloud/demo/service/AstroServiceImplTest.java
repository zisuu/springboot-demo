package ch.finecloud.demo.service;

import ch.finecloud.demo.json.Assignment;
import ch.finecloud.demo.json.AstroResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceImplTest {

    @Autowired
    private AstroService astroService;

    @Test
    void getAstronautsRT() {
        AstroResult astroResult = astroService.getAstronautsRT();
        int number = astroResult.number();
        System.out.println("There are " + number + " astronauts in space right now.");
        List<Assignment> people = astroResult.people();
        people.forEach(System.out::println);
        assertAll(
                () -> assertTrue(number >= 0),
                () -> assertEquals(number, people.size())
        );
    }

    @Test
    void getAstronautsWC() {
        AstroResult astroResult = astroService.getAstronautsWC();
        int number = astroResult.number();
        System.out.println("There are " + number + " astronauts in space right now.");
        List<Assignment> people = astroResult.people();
        people.forEach(System.out::println);
        assertAll(
                () -> assertTrue(number >= 0),
                () -> assertEquals(number, people.size())
        );
    }
}
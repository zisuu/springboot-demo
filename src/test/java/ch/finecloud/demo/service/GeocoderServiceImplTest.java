package ch.finecloud.demo.service;

import ch.finecloud.demo.entities.Site;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeocoderServiceImplTest {

    @Autowired
    private GeocoderService geocoderService;

    @Test
    public void getLatLngWithoutStreet() throws Exception {
        Site site = geocoderService.getLatLong("Boston", "MA");
        assertEquals(42.36, site.lat(), 0.01);
        assertEquals(-71.06, site.lng(), 0.01);
    }

    @Test
    public void getLatLngWithStreet() throws Exception {
        Site site = geocoderService.getLatLong("1600 Ampitheatre Parkway",
                "Mountain View", "CA");
        assertEquals(37.42, site.lat(), 0.01);
        assertEquals(-122.08, site.lng(), 0.01);
    }
}
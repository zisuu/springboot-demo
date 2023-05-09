package ch.finecloud.demo.service;

import ch.finecloud.demo.entities.Site;

public interface GeocoderService {
    Site getLatLong(String ... address);
}

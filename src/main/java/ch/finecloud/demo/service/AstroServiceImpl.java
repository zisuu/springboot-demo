package ch.finecloud.demo.service;

import ch.finecloud.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroServiceImpl implements AstroService {

    private final RestTemplate restTemplate;

    @Autowired
    public AstroServiceImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    @Override
    public AstroResult getAstronauts() {
        String url = "http://api.open-notify.org/astros.json";
        return this.restTemplate.getForObject(url, AstroResult.class);
    }
}

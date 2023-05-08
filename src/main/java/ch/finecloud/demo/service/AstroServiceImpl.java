package ch.finecloud.demo.service;

import ch.finecloud.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroServiceImpl implements AstroService {

    private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Autowired
    public AstroServiceImpl(RestTemplateBuilder restTemplate, WebClient.Builder webClient) {
        this.restTemplate = restTemplate.build();
        this.webClient = webClient.baseUrl("http://api.open-notify.org").build();
    }

    @Override
    public AstroResult getAstronautsRT() {
        String url = "http://api.open-notify.org/astros.json";
        return this.restTemplate.getForObject(url, AstroResult.class);
    }

    @Override
    public AstroResult getAstronautsWC() {
        return webClient.get()
                .uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResult.class)
                .block(Duration.ofSeconds(2));
    }
}

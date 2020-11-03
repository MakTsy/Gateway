package com.gateway.demo.controllers;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("info")
@NoArgsConstructor
public class InfoController {

    private final String url = "http://localhost:8081/info";

    @GetMapping(value = "/allFlights", produces = "application/json")
    public ResponseEntity<String> getFlights() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> answer = restTemplate.exchange(url+"/allFlights", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {});
        return answer;
    }


}

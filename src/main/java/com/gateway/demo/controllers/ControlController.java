package com.gateway.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@RestController
public class ControlController {

    private final String url = "http://localhost:8087";


    @PostMapping("/customControl/greenLine")
    public ResponseEntity<Void> passControll(@RequestParam("id") UUID passangerId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> answer = restTemplate.exchange(url + "/customControl/greenLine?id=" + passangerId,
                HttpMethod.POST, null, new ParameterizedTypeReference<>() {});
        return ResponseEntity.ok().build();
    }

    @PostMapping("/customControl/redLine")
    public ResponseEntity<Void> passControl(@RequestParam("id") UUID passangerId, @RequestParam("description") String text) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> answer = restTemplate.exchange(url + "/customControl/redLine?id=" + passangerId +
                        "&description=" + text,
                HttpMethod.POST, null, new ParameterizedTypeReference<>() {
                });
        return ResponseEntity.ok().build();
    }

    @PostMapping("/borderControl")
    public ResponseEntity<Void> passBorderControll(@RequestParam("id") UUID passangerId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> answer = restTemplate.exchange(url + "/borderControl?id=" + passangerId,
                HttpMethod.POST, null, new ParameterizedTypeReference<>() {});
        return ResponseEntity.ok().build();
    }

    @PostMapping("/flightControl")
    public ResponseEntity<Void> passFlightControll(@RequestParam("id") UUID passangerId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> answer = restTemplate.exchange(url + "/flightControl?id=" + passangerId,
                HttpMethod.POST, null, new ParameterizedTypeReference<>() {});
        return ResponseEntity.ok().build();
    }

}

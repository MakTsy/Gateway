package com.gateway.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class BaggageController {
    private final String url = "http://localhost:8086";


    @PostMapping("/getMyBaggage")
    public ResponseEntity<Void> getBaggage(@RequestParam("id") UUID baggageId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> answer = restTemplate.exchange(url + "/getMyBaggage?id=" + baggageId,
                HttpMethod.POST, null, new ParameterizedTypeReference<>() {});
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/checkInBaggage")
    public ResponseEntity<Void> checkInBaggage(@RequestParam("id") UUID passangerId, @RequestParam("weight") float weight) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> answer = restTemplate.exchange(url + "/checkInBaggage?id=" + passangerId + "&weight=" + weight ,
                HttpMethod.POST, null, new ParameterizedTypeReference<>() {});
        return ResponseEntity.ok().build();
    }
}

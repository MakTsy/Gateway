package com.gateway.demo.controllers;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class CheckInController {
    private final String url = "http://localhost:8085";

    @PostMapping("/check_in")
    public ResponseEntity<String> checkInClient(@RequestParam("ticket_id") UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> answer = restTemplate.exchange(url + "/check_in?ticket_id=" + id,
                HttpMethod.POST, null, new ParameterizedTypeReference<>() {});
        return new ResponseEntity<String>(answer.getBody(), HttpStatus.OK);

    }
}

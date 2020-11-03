package com.gateway.demo.controllers;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("client")
public class ClientController {
    private final String url = "http://localhost:8083/client";

    @PostMapping("/newOne")
    public ResponseEntity<UUID> createClient(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UUID> answer = restTemplate.exchange(url + "/newOne?name=" + name + "&surname=" + surname ,
                        HttpMethod.POST, null, new ParameterizedTypeReference<>() {});
        return new ResponseEntity<UUID>(answer.getBody(), HttpStatus.OK);
    }
}

package com.gateway.demo.controllers;

import com.gateway.demo.dto.FlightDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("flights")
@NoArgsConstructor
public class FlightControlController {
    private final String url = "http://localhost:8082/flights";

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> createFlight(@RequestBody FlightDTO delJson) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FlightDTO> answer = restTemplate.postForEntity(url+"/add", delJson, FlightDTO.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getFlights", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> sendFlights() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> answer = restTemplate.exchange(url+"/getFlights", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {});
        return answer;
    }

}


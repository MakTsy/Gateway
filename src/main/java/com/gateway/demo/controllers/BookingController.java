package com.gateway.demo.controllers;

import com.gateway.demo.dto.FlightDTO;
import com.gateway.demo.dto.TicketDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@NoArgsConstructor
public class BookingController {

    private final String url = "http://localhost:8084";

    @RequestMapping(value="book",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<String> bookTicket(@RequestBody TicketDTO delJson) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> answer = restTemplate.postForEntity(url+"/book", delJson, String.class);
        return new ResponseEntity<String>(answer.getBody(), HttpStatus.OK);
    }

}

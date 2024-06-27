package com.onesoft.helloresttemplate1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class Hello1 {

    @Autowired
    RestTemplate restTemplate;

    private static final String MONGODB_BASE_URL = "http://localhost:8080";

    @GetMapping("/getData")
    public List<MongoDbEntity> getAllData() {
        String url = MONGODB_BASE_URL + "/mob2";
        ResponseEntity<List<MongoDbEntity>> response = restTemplate.exchange(url, HttpMethod.GET, null, 
                new ParameterizedTypeReference<List<MongoDbEntity>>() {});
        return response.getBody();
    }

    @PostMapping("/postData")
    public String postData(@RequestBody MongoDbEntity entity) {
        String url = MONGODB_BASE_URL + "/mob";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(entity), String.class);
        return response.getBody();
    }

    @PutMapping("/updateData")
    public String updateData(@RequestBody MongoDbEntity entity) {
        String url = MONGODB_BASE_URL + "/mob5";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(entity), String.class);
        return response.getBody();
    }
}

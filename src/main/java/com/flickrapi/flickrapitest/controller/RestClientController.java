package com.flickrapi.flickrapitest.controller;

import com.flickrapi.flickrapitest.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/flickr-data")
public class RestClientController {

    @Autowired
    private RestClientService service;

    @GetMapping
    public ResponseEntity<?> getDataString() {
        return service.getDataString();
    }

    @GetMapping("/tes")
    public String tes() {
        return "Hello";
    }
}

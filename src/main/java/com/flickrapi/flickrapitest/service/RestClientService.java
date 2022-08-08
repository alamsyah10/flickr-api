package com.flickrapi.flickrapitest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getDataString() {
        ResponseEntity<String> response = restTemplate.getForEntity(
            "https://api.flickr.com/services/feeds/photos_public.gne?format=json",
                String.class
        );
        return response;
    }
}

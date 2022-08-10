package com.flickrapi.flickrapitest.service;

import com.flickrapi.flickrapitest.dto.JsonFlickrFeed;
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
            "https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1",
                String.class
        );

        return response;
    }

    public ResponseEntity<JsonFlickrFeed> getData(String param) {
        JsonFlickrFeed response;
        if (param == null || param.isEmpty()) {
            response = restTemplate.getForObject(
                    "https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1",
                    JsonFlickrFeed.class
            );
        } else {
            response = restTemplate.getForObject(
                    "https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1"+"&tags="+param,
                    JsonFlickrFeed.class
            );
        }

        return ResponseEntity.ok(response);
    }
}

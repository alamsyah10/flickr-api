package com.flickrapi.flickrapitest.controller;

import com.flickrapi.flickrapitest.dto.Items;
import com.flickrapi.flickrapitest.dto.JsonFlickrFeed;
import com.flickrapi.flickrapitest.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/feed")
    public Items[] getItems() {
        ResponseEntity<JsonFlickrFeed> data = service.getData("");
        return data.getBody().getItems();
    }

    @GetMapping("/feed/{tag}")
    public Items[] getItemsByTag(@PathVariable("tag") String tag) {
        ResponseEntity<JsonFlickrFeed> data = service.getData(tag);
        return data.getBody().getItems();
    }

    @GetMapping("/data")
    public ResponseEntity<JsonFlickrFeed> getData() {
        return service.getData("");
    }
}

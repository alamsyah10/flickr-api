package com.flickrapi.flickrapitest.controller;

import com.flickrapi.flickrapitest.dto.Items;
import com.flickrapi.flickrapitest.dto.JsonFlickrFeed;
import com.flickrapi.flickrapitest.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/flickr-data")
public class RestClientController {

    @Autowired
    private RestClientService service;

    @GetMapping("/tes")
    public String tes() {
        return "Hello";
    }

    @GetMapping
    public Items[] getItems() {
        ResponseEntity<JsonFlickrFeed> data = service.getData("");
        return data.getBody().getItems();
    }

    @GetMapping("/feed")
    public Items[] getItemsByParamsTag(@RequestParam(required = false, name = "tag") String tag) {
        ResponseEntity<JsonFlickrFeed> data = service.getData(tag);
        return data.getBody().getItems();
    }

    @GetMapping("/data")
    public ResponseEntity<JsonFlickrFeed> getData() {
        return service.getData("");
    }
}

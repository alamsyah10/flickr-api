package com.flickrapi.flickrapitest.controller;

import com.flickrapi.flickrapitest.dto.Items;
import com.flickrapi.flickrapitest.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        Items[] data = service.getData("","");
        return data;
    }

    @GetMapping("/feed")
    public Items[] getItemsByParamsTag(
            @RequestParam(required = false, name = "tag") String tag,
            @RequestParam(required = false, name = "title") String title) {
        Items[] data = service.getData(tag, title);
        return data;
    }



//    @GetMapping("/data")
//    public ResponseEntity<JsonFlickrFeed> getData() {
//        return service.getData("","");
//    }
}

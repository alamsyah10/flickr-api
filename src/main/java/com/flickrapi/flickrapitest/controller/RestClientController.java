package com.flickrapi.flickrapitest.controller;

import com.flickrapi.flickrapitest.dto.Items;
import com.flickrapi.flickrapitest.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/feed/{page}") //per page only contains 5 data, total feed data = 20, total page 4
    public Items[] getPageItemsByParamsTag(@PathVariable("page") int page) {
        if (page < 1 || page > 4) {
            return null;
        }
        Items[] data = service.getDataByPage(page);
        return data;
    }
}

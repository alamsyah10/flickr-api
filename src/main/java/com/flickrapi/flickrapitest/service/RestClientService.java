package com.flickrapi.flickrapitest.service;

import com.flickrapi.flickrapitest.dto.Items;
import com.flickrapi.flickrapitest.dto.JsonFlickrFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

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

    public Items[] getData(String tag, String title) {
        JsonFlickrFeed response;
        if (tag == null || tag.isEmpty()) {
            response = restTemplate.getForObject(
                    "https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1",
                    JsonFlickrFeed.class
            );
        } else {
            response = restTemplate.getForObject(
                    "https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1"+"&tags="+tag,
                    JsonFlickrFeed.class
            );
        }

        ResponseEntity<JsonFlickrFeed> data = ResponseEntity.ok(response);
        int arr_size = 0;
        if (title == null || title.isEmpty()) {
            Items[] items = data.getBody().getItems();
        } else {
            Items[] items = data.getBody().getItems();

            for (int i=0; i<items.length; i++) {
                if (items[i].getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase())) {
                    arr_size++;
                }
            }
        }
        Items[] new_items = data.getBody().getItems();
        if (arr_size > 0) {
            Items[] items = data.getBody().getItems();
            new_items = new Items[arr_size];
            int index = 0;
            for (int i=0; i<items.length; i++) {
                if (items[i].getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase())) {
                    new_items[index] = items[i];
                    index++;
                }
            }
        }

        return new_items;
    }
}

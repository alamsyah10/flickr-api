package com.flickrapi.flickrapitest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class JsonFlickrFeed {
    private String title;
    private String link;
    private String description;
    private Date modified;
    private String generator;
    private Items[] items;
}

package com.flickrapi.flickrapitest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Items {
    private String title;
    private String link;
    private Media media;
    private Date date_taken;
    private String description;
    private Date published;
    private String author;
    private String author_id;
    private String tags;
}

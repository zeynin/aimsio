package com.vaadin.demo.dashboard.domain;

import java.util.Date;

/**
 * Created by Zeynin on 2016-06-10.
 */
public class PxPhoto
{
    private long id;
    private String name;
    private Date dateTaken;
    private String imageUrl;
    private String description;
    private String username;

    public void setId(final long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDateTaken(final Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Date getReleaseDate() {
        return dateTaken;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
/* Flickr JSON description
"name":
"link":
"description"
"modified": "
"generator":
"items": [
    "name":
    "link":
    "media":
        "m":
    "date_taken":
    "description"
    "published":
    "author":
    "author_id":
    "tags": ""
 */
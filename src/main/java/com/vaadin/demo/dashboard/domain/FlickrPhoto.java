package com.vaadin.demo.dashboard.domain;

import java.util.Date;

/**
 * Created by Zeynin on 2016-06-01.
 */
public class FlickrPhoto
{
    private long id;
    private String title;
    private Date dateTaken;
    private String mediaLink;
    private String description;
    private String authorID;

    public void setId(final long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDateTaken(final Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Date getReleaseDate() {
        return dateTaken;
    }

    public void setMediaLink(final String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAuthorID(final String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorID() {
        return authorID;
    }

}
/* Flickr JSON description
"title":
"link":
"description"
"modified": "
"generator":
"items": [
    "title":
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
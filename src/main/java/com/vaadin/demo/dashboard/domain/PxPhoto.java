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
/* 500px JSON description
{
    "current_page": 1,
    "total_pages": 1000,
    "total_items": 39860,
    "photos": [
        {
            "id": 157834085,
            "user_id": 1776781,
            "name": "Red in the morning",
            "description": "Garden in the Water in Yangsuri, Korea.",
            "camera": "Canon EOS 5D Mark III",
            "lens": "EF24-70mm f/2.8L II USM",
            "focal_length": "38",
            "iso": "100",
            "shutter_speed": "1/125",
            "aperture": "9",
            "times_viewed": 7261,
            "rating": 99.7,
            "status": 1,
            "created_at": "2016-06-09T10:11:33-04:00",
            "category": 18,
            "location": null,
            "latitude": null,
            "longitude": null,
            "taken_at": "2016-06-09T06:26:59-04:00",
            "hi_res_uploaded": 0,
            "for_sale": false,
            "width": 1600,
            "height": 900,
            "votes_count": 1630,
            "favorites_count": 0,
            "comments_count": 115,
            "nsfw": false,
            "sales_count": 0,
            "for_sale_date": null,
            "highest_rating": 99.7,
            "highest_rating_date": "2016-06-10T05:56:16-04:00",
            "license_type": 0,
            "converted": 27,
            "collections_count": 145,
            "crop_version": 2,
            "privacy": false,
            "profile": true,
            "image_url": "https://drscdn.500px.org/photo/157834085/q%3D50_w%3D140_h%3D140/d91c8ebd5d910e76ddeb5ac1654e5920?v=2",
            "images": [
                {
                    "size": 2,
                    "url": "https://drscdn.500px.org/photo/157834085/q%3D50_w%3D140_h%3D140/d91c8ebd5d910e76ddeb5ac1654e5920?v=2",
                    "https_url": "https://drscdn.500px.org/photo/157834085/q%3D50_w%3D140_h%3D140/d91c8ebd5d910e76ddeb5ac1654e5920?v=2",
                    "format": "jpeg"
                }
            ],
            "url": "/photo/157834085/red-in-the-morning-by-tiger-seo",
            "positive_votes_count": 1630,
            "converted_bits": 27,
            "watermark": false,
            "image_format": "jpeg",
            "user": {
                "id": 1776781,
                "username": "TigerSeo",
                "firstname": "Tiger",
                "lastname": "Seo",
                "city": "Goyang",
                "country": "South Korea",
                "usertype": 0,
                "fullname": "Tiger Seo",
                "userpic_url": "https://pacdn.500px.org/1776781/424c9425e6e2fa700c3f2fc5c59817d15dbb2ba9/1.jpg?18",
                "userpic_https_url": "https://pacdn.500px.org/1776781/424c9425e6e2fa700c3f2fc5c59817d15dbb2ba9/1.jpg?18",
                "cover_url": "https://pacdn.500px.org/1776781/424c9425e6e2fa700c3f2fc5c59817d15dbb2ba9/cover_2048.jpg?83",
                "upgrade_status": 0,
                "store_on": true,
                "affection": 608860,
                "avatars": {
                    "default": {
                        "https": "https://pacdn.500px.org/1776781/424c9425e6e2fa700c3f2fc5c59817d15dbb2ba9/1.jpg?18"
                    },
                    "large": {
                        "https": "https://pacdn.500px.org/1776781/424c9425e6e2fa700c3f2fc5c59817d15dbb2ba9/2.jpg?18"
                    },
                    "small": {
                        "https": "https://pacdn.500px.org/1776781/424c9425e6e2fa700c3f2fc5c59817d15dbb2ba9/3.jpg?18"
                    },
                    "tiny": {
                        "https": "https://pacdn.500px.org/1776781/424c9425e6e2fa700c3f2fc5c59817d15dbb2ba9/4.jpg?18"
                    }
                },
                "followers_count": 0
            },
            "licensing_requested": false,
            "licensing_suggested": false
        }, */
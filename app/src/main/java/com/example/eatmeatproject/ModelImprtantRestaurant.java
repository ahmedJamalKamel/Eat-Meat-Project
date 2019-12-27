package com.example.eatmeatproject;


public class ModelImprtantRestaurant {
    private String name;
    private String desc;
    private String image_url;

    public ModelImprtantRestaurant() {
    }

    public ModelImprtantRestaurant(String image_url, String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getimage_url() {
        return image_url;
    }

    public void setimage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getdesc() {
        return desc;
    }

    public void setdesc(String dis) {
        this.desc = dis;
    }
}

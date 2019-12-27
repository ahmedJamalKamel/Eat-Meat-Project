package com.example.eatmeatproject;


public class ModelNotification {
    private String name;
    private String dis;
    private String image_url;
    public ModelNotification(){}
    public ModelNotification(String image_url, String name, String dis )
    {
        this.name=name;
        this.dis=dis;
        this.image_url=image_url;
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
    public String getdis() {
        return dis;
    }
    public void setdis(String dis) {
        this.dis = dis;
    }
}

package com.example.eatmeatproject;


public class ImportantDishes {
    private String name;
    private String name_ar;
    private String image_url;
    private String time;
    public ImportantDishes(){}
    public ImportantDishes(String image_url,String name,String name_ar,String time)
    {
        this.name=name;
        this.name_ar=name_ar;
        this.image_url=image_url;
        this.time=time;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getimage_url() {
        return image_url;
    }

    public void setimage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

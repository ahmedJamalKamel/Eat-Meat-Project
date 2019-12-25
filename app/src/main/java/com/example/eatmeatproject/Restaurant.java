package com.example.eatmeatproject;

import android.location.Location;

public class Restaurant {
   private String desc,desc_ar,image_url,name_ar,res_id,name;
   private Location location;

    public Restaurant(String desc, String desc_ar, String image_url, String name_ar, String res_id, String name, Location location) {
        this.desc = desc;
        this.desc_ar = desc_ar;
        this.image_url = image_url;
        this.name_ar = name_ar;
        this.res_id = res_id;
        this.name = name;
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc_ar() {
        return desc_ar;
    }

    public void setDesc_ar(String desc_ar) {
        this.desc_ar = desc_ar;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

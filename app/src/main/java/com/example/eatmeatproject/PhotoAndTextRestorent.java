package com.example.eatmeatproject;

public class PhotoAndTextRestorent {
    private String potoTitle;
    private int imageResoursId;


    public PhotoAndTextRestorent(String potoTitle, int imageResoursId) {
        this.potoTitle = potoTitle;
        this.imageResoursId = imageResoursId;
    }

    public String getPotoTitle() {
        return potoTitle;
    }

    public void setPotoTitle(String potoTitle) {
        this.potoTitle = potoTitle;
    }

    public int getImageResoursId() {
        return imageResoursId;
    }

    public void setImageResoursId(int imageResoursId) {
        this.imageResoursId = imageResoursId;
    }
}

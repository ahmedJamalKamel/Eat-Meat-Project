package com.example.eatmeatproject;

public class PhotoAndTextNotidication {
    private String potoTitle;
    private int imageResoursId;


    public PhotoAndTextNotidication(String potoTitle, int imageResoursId) {
        this.potoTitle = potoTitle;
        this.imageResoursId = imageResoursId;
    }

    private String getPotoTitle() {
        return potoTitle;
    }

    private void setPotoTitle(String potoTitle) {
        this.potoTitle = potoTitle;
    }

    private int getImageResoursId() {
        return imageResoursId;
    }

    private void setImageResoursId(int imageResoursId) {
        this.imageResoursId = imageResoursId;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.model;

/**
 *
 * @author lmolina
 */
public class FavoriteCat {
    String id;
    String image_id;
    ImageCat image;

    public FavoriteCat() {
    }

    public FavoriteCat(String id, String image_id, ImageCat image) {
        this.id = id;
        this.image_id = image_id;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public ImageCat getImage() {
        return image;
    }

    public void setImage(ImageCat image) {
        this.image = image;
    }
    
}

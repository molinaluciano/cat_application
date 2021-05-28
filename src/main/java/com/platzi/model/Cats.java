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
public class Cats {
    String id;
    String url;
    String apikey;
    String image;

    public Cats(String id, String url, String apikey, String image) {
        this.id = id;
        this.url = url;
        this.apikey = apikey;
        this.image = image;
    }

    public Cats() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}

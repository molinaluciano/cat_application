/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.facade;

import com.platzi.model.Cats;
import com.platzi.model.FavoriteCat;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmolina
 */
public class CatFacadeImpl implements CatFacade {
    String apiKey = "87d4a67e-83d3-4c68-81bb-afa891616098";
    
    @Override
    public Response getCats() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
        .url("https://api.thecatapi.com/v1/images/search")
        .method("GET", null)
        .build();
        
        Response response = null;
        try {
            response = client.newCall(request).execute();
            
        } catch (IOException ex) {
            Logger.getLogger(CatFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    @Override
    public Response favoriteCat(Cats cat) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n  \"image_id\": \""+ cat.getId()+"\",\n  \"sub_id\": \""+ cat.getId()+"\"\n}");
        Request request = new Request.Builder()
            .url("https://api.thecatapi.com/v1/favourites")
            .method("POST", body)
            .addHeader("x-api-key", apiKey)
            .addHeader("Content-Type", "application/json")
            .build();
        
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(CatFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    @Override
    public Response getFavoritesCats() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("https://api.thecatapi.com/v1/favourites")
            .method("GET", null)
            .addHeader("x-api-key", apiKey)
            .addHeader("Content-Type", "application/json")
            .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(CatFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    @Override
    public Response deleteFavorite(FavoriteCat favoriteCat) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
          .url("https://api.thecatapi.com/v1/favourites/"+favoriteCat.getId())
          .method("DELETE", null)
          .addHeader("x-api-key", apiKey)
          .addHeader("Content-Type", "application/json")
          .build();
        Response response = null;
        try {
            response= client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(CatFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
    
}

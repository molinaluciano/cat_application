/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.facade;

import com.platzi.model.Cats;
import com.platzi.model.FavoriteCat;
import com.squareup.okhttp.Response;

/**
 *
 * @author lmolina
 */
public interface CatFacade {
    public Response getCats();
    public Response favoriteCat(Cats cat);
    public Response getFavoritesCats();
    public Response deleteFavorite(FavoriteCat favoriteCat);

}

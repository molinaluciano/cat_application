/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.service;

import com.platzi.model.Cats;
import com.platzi.model.FavoriteCat;

/**
 *
 * @author lmolina
 */
public interface CatService {
    public void showCats();
    public void favoriteCat(Cats cats);
    public void showFavorites();
    public void deleteFavorite(FavoriteCat favoriteCat);
}

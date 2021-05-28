/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.service;

import com.google.gson.Gson;
import com.platzi.facade.CatFacadeImpl;
import com.platzi.model.Cats;
import com.platzi.model.FavoriteCat;
import com.platzi.util.Utils;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author lmolina
 */
public class CatServiceImpl implements CatService {
    CatFacadeImpl catFacade = new CatFacadeImpl();
    Utils utils = new Utils();
    @Override
    public void showCats() {
        try {
            Response response = catFacade.getCats();
            String responseJson = null;
            
            responseJson = response.body().string();
            responseJson = responseJson.substring(1, responseJson.length());
            responseJson = responseJson.substring(0, responseJson.length() - 1);
            
            
            //create an object to class gson
            Gson gson = new Gson();
            Cats cats = gson.fromJson(responseJson, Cats.class);
            
            
            URL url = null;
            url = new URL(cats.getUrl());
             
            
          
            ImageIcon imageCat = null;
            imageCat = utils.readImage(url);
            
            
            String main = "Opciones: \n"
                    + "1. See other cat \n"
                    + "2. Favorite \n"
                    + "3. Back \n";
            
            String[] buttons = {"See other cat", "Favorite", "Back"};
            String id_cat = String.valueOf(cats.getId());
            String opcion = (String) JOptionPane.showInputDialog(null, main, id_cat, JOptionPane.INFORMATION_MESSAGE,imageCat, buttons, buttons[0]);
            
            int seleccion = -1;
            for(int i=0; i<buttons.length; i++){
                if(opcion.equals(buttons[i])){
                    seleccion = i;
                }
            }
            
            switch(seleccion){
                case 0:
                    showCats();
                    break;
                case 1:
                    favoriteCat(cats);
                    break;
                default:
                    break;
            }
            
            
        } 
        catch (IOException ex) {
            Logger.getLogger(CatServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
    }

    @Override
    public void favoriteCat(Cats cats) {
      Response response =  catFacade.favoriteCat(cats);
    }

    @Override
    public void showFavorites() {
        try {
            Response response =  catFacade.getFavoritesCats();
            String responseJson = null;
            
            responseJson = response.body().string();
            
            
            //create an object to class gson
            Gson gson = new Gson();
            FavoriteCat[] arrayCats = gson.fromJson(responseJson, FavoriteCat[].class);
            if(arrayCats.length > 0){
                int min = 1;
                int max = arrayCats.length;
                int random = (int) (Math.random() * ((max - min) +1)) + min ;
                int index = random-1;
                
                FavoriteCat bestCat = arrayCats[index];
                
                URL url = null;
                url = new URL(bestCat.getImage().getUrl());

                ImageIcon imageCat = null;
                imageCat = utils.readImage(url);
                
                
                
                String main = "Opciones: \n"
                        + "1. See other cat \n"
                        + "2. Delete to Favorite \n"
                        + "3. Back \n";

                String[] buttons = {"See other cat", "Delete Favorite", "Back"};
                String id_cat = bestCat.getId();
                String opcion = (String) JOptionPane.showInputDialog(null, main, id_cat, JOptionPane.INFORMATION_MESSAGE,imageCat, buttons, buttons[0]);

                int seleccion = -1;
                for(int i=0; i<buttons.length; i++){
                    if(opcion.equals(buttons[i])){
                        seleccion = i;
                    }
                }

                switch(seleccion){
                    case 0:
                        showFavorites();
                        break;
                    case 1:
                        deleteFavorite(bestCat);
                        break;
                    default:
                        break;
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(CatServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteFavorite(FavoriteCat favoriteCat) {
        Response response = catFacade.deleteFavorite(favoriteCat);
    }

    
    
}

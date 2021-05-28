/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.cat_app;

import com.platzi.service.CatServiceImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author lmolina
 */
public class Main {
     public static void main(String[] args){
        int option_main = -1;
        String[] buttons = {"1. Show cats", "2. Ver favoritos","3. Exit" };
        
        do{
            String opcion = (String) JOptionPane.showInputDialog(null, "Cats in Java", "First Main", JOptionPane.INFORMATION_MESSAGE,null, buttons, buttons[0]);
            
            for(int i=0; i<buttons.length; i++){
                if(opcion.equals(buttons[i])){
                    option_main = i;
                }
            }
            CatServiceImpl catService = new CatServiceImpl();
            switch(option_main){
                case 0:
                    catService.showCats();
                    break;
                case 1:
                    catService.showFavorites();
                    break;
                default:
                    break;
            }
        }while(option_main != 1);
     }
}

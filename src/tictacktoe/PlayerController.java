/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.util.ArrayList;

/**
 *
 * @author moh
 */
public class PlayerController {
   private PlayerModel model ;
   private PlayerView view ;

    public PlayerController(PlayerModel model, PlayerView view) {
        this.model = model;
        this.view = view;
    }
    
    
    public void setActive (ArrayList <PlayerModel> active) {
        model.setRecords(active);
       view.addRowToJTable(model.getData());
    }
    
    
    
    
}

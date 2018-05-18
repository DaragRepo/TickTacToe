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
public class PlayerModel {
    
    private String playerName ;

    private ArrayList <PlayerModel> records;
    public PlayerModel(String playerName) {
        this.playerName = playerName;
    }

    public void setRecords(ArrayList<PlayerModel> records) {
        this.records = records;        
    }
    
    
    
     public ArrayList<PlayerModel> getData () {
        return records ;
    }

    public String getPlayerName() {
        return playerName;
    }

  
    
    
    
    
}

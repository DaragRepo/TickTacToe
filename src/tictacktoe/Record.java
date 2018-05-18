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
public class Record {
    private String playerOne ; 
    private String playerTwo;
    private String winner ;
    private ArrayList <Record> records;
    public Record(String playerOne, String playerTwo, String winner) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.winner = winner;
    }
    
   
    
    
    public ArrayList<Record> addData () {
        records = new ArrayList ();
        records.add(new Record(playerOne, playerTwo, winner));
        return records ;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public String getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "Record{" + "playerOne=" + playerOne + ", playerTwo=" + playerTwo + ", winner=" + winner + '}';
    }
    
    
    
    
    
    
    
    
    
    
}

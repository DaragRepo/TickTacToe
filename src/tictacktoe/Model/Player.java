/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author fake
 */
public class Player {

    private char PlayerLetter;
    private String name;

    public Player(String name, char letter) {
        this.name = name;
        PlayerLetter = letter;
    }

    public char getPlayerLetter() {
        return (PlayerLetter);
    }

    public String getName() {
        return (name);
    }

    public void setPlayerLetter(char l) {
        PlayerLetter = l;
    }

    public void setName(String n) {
        name = n;
    }
}

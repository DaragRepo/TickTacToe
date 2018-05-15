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
public class Cell {

    private int number;
    private char value;

    public Cell(int number) {
        this.number = number;
        value = 'N';
    }

    public boolean isEmpty() {
        if (value == 'N') {
            return true;
        } else {
            return false;
        }
    }

    public void setValue(char v) {
        value = v;
    }

    public char getValue() {
        return (value);
    }

    public int getNumber() {
        return (number);
    }

}

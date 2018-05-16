package tictacktoe;


import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fake
 */
public class CheckingUpdates implements Runnable {

    private Controller C;

    public CheckingUpdates(Controller C) {
        this.C = C;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                C.UpdateBoard();
            } catch (RemoteException ex) {
                Logger.getLogger(CheckingUpdates.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

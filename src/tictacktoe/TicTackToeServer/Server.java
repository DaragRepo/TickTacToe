package tictacktoe.TicTackToeServer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fake
 */
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {
        try {
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            r.rebind("M", new Model("islam","ahmed"));
 
        } catch (Exception e) {
            System.out.println("Server not connected: " + e);
        }
    }
}

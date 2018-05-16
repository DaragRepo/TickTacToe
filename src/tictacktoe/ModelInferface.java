package tictacktoe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tictacktoe.TicTackToeServer.Cell;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author fake
 */
public interface ModelInferface extends Remote {

    public ArrayList<Cell> getCells() throws RemoteException;

    public boolean checkifcellEmpty(int n) throws RemoteException;

    public void FillCell(int cell) throws RemoteException;

    public boolean CheckGameStatus() throws RemoteException;

    public char getPlayerChar() throws RemoteException;

    public char getTurn() throws RemoteException;
    // public String test() throws RemoteException;
}

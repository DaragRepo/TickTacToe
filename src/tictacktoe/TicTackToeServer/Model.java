package tictacktoe.TicTackToeServer;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fake
 */
public class Model extends UnicastRemoteObject implements ModelInferface {

    private ArrayList<Cell> Cells;
    private Player p1;
    private Player p2;
    private boolean Player1;
    private boolean Player2;
    private char Turn;

    public Model(String p1_name, String p2_name) throws RemoteException {
        super();
        Cells = new ArrayList<>();
        p1 = new Player(p1_name, 'x');
        p2 = new Player(p2_name, 'o');
        Turn = 'x';
        for (int i = 1; i < 10; i++) {
            Cell x = new Cell(i);
            Cells.add(x);
        }
        Player1 = Player2 = false;
    }

    public ArrayList<Cell> getCells() throws RemoteException {
        return (Cells);
    }

    public boolean checkifcellEmpty(int n) throws RemoteException {
        if (Cells.get(n).getValue() == 'N') {
            return (true);
        } else {
            return (false);
        }
    }

    public void FillCell(int cell) throws RemoteException {
        Cells.get(cell).setValue(Turn);
        if (Turn == 'x') {
            Turn = 'o';
        } else if (Turn == 'o') {
            Turn = 'x';
        }
    }

    public boolean CheckGameStatus() throws RemoteException {
        if ((Cells.get(0).getValue() == 'x' && Cells.get(1).getValue() == 'x' && Cells.get(2).getValue() == 'x') || (Cells.get(0).getValue() == 'o' && Cells.get(1).getValue() == 'o' && Cells.get(2).getValue() == 'o')) {
            return true;
        } else if ((Cells.get(3).getValue() == 'x' && Cells.get(4).getValue() == 'x' && Cells.get(5).getValue() == 'x') || (Cells.get(3).getValue() == 'o' && Cells.get(4).getValue() == 'o' && Cells.get(5).getValue() == 'o')) {
            return true;
        } else if ((Cells.get(6).getValue() == 'x' && Cells.get(7).getValue() == 'x' && Cells.get(8).getValue() == 'x') || (Cells.get(6).getValue() == 'o' && Cells.get(7).getValue() == 'o' && Cells.get(8).getValue() == 'o')) {
            return true;
        } else if ((Cells.get(1).getValue() == 'x' && Cells.get(4).getValue() == 'x' && Cells.get(7).getValue() == 'x') || (Cells.get(1).getValue() == 'o' && Cells.get(4).getValue() == 'o' && Cells.get(7).getValue() == 'o')) {
            return true;
        } else if ((Cells.get(2).getValue() == 'x' && Cells.get(5).getValue() == 'x' && Cells.get(8).getValue() == 'x') || (Cells.get(2).getValue() == 'o' && Cells.get(5).getValue() == 'o' && Cells.get(8).getValue() == 'o')) {
            return true;
        } else if ((Cells.get(0).getValue() == 'x' && Cells.get(3).getValue() == 'x' && Cells.get(6).getValue() == 'x') || (Cells.get(0).getValue() == 'o' && Cells.get(3).getValue() == 'o' && Cells.get(6).getValue() == 'o')) {
            return true;
        } else if ((Cells.get(0).getValue() == 'x' && Cells.get(4).getValue() == 'x' && Cells.get(8).getValue() == 'x') || (Cells.get(0).getValue() == 'o' && Cells.get(4).getValue() == 'o' && Cells.get(8).getValue() == 'o')) {
            return true;
        } else if ((Cells.get(2).getValue() == 'x' && Cells.get(4).getValue() == 'x' && Cells.get(6).getValue() == 'x') || (Cells.get(2).getValue() == 'o' && Cells.get(4).getValue() == 'o' && Cells.get(6).getValue() == 'o')) {
            return true;
        } else {
            return false;
        }
    }

    public char getPlayerChar() throws RemoteException {
        if (!Player1 && !Player2) {
            Player1 = true;
            return ('x');
        } else {
            Player2 = true;
            return ('o');
        }

    }

    public char getTurn() {
        return (Turn);
    }

}

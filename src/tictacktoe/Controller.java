package tictacktoe;


import tictacktoe.TicTackToeServer.Cell;
import java.awt.Cursor;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fake
 */
public class Controller {

    private ModelInferface m;
    private View v;
    private char MyChar;

    public Controller(ModelInferface m, View v) throws RemoteException {
        this.m = m;
        this.v = v;
        getMyChar();
        UpdateBoard();
        CheckingUpdates Checking = new CheckingUpdates(this);
        Thread x = new Thread(Checking);
        x.start();
    }

    public void adaptCellCursor(JLabel l, int cellNum) throws RemoteException {
        char turn = m.getTurn();
        if (MyChar == turn) {
            if (m.checkifcellEmpty(cellNum)) {
                l.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

        } else {
            l.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

    }

    public void RequestFillingCell(int cellNum) throws RemoteException {
        char turn = m.getTurn();
        if (MyChar == turn) {
            if (m.checkifcellEmpty(cellNum)) {
                m.FillCell(cellNum);
                UpdateBoard();
                if (m.CheckGameStatus()) {
                    System.out.println("Game is finished");
                }
            }
        }

    }

    public void UpdateBoard() throws RemoteException {
        ArrayList<JLabel> VCells = v.getCells();
        ArrayList<Cell> MCells = m.getCells();
        for (int i = 0; i < VCells.size(); i++) {
            char status = MCells.get(i).getValue();
            if (status == 'N') {
                VCells.get(i).setText("");
            } else {
                VCells.get(i).setText(String.valueOf(status));
                VCells.get(i).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }

    public void getMyChar() {
        try {
            MyChar = m.getPlayerChar();
        } catch (RemoteException r) {

        }
    }

}

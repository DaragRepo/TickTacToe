
import Model.Cell;
import Model.Model;
import java.awt.Cursor;
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

    private Model m;
    private View v;

    public Controller(Model m, View v) {
        this.m = m;
        this.v = v;
        UpdateBoard();
    }

    public void adaptCellCursor(JLabel l, int cellNum) {

        if (m.checkifcellEmpty(cellNum)) {
            l.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } 

    }

    public void RequestFillingCell(int cellNum) {
        if(m.checkifcellEmpty(cellNum)){
            m.FillCell(cellNum);
            UpdateBoard();
            if(m.CheckGameStatus()){
                System.out.println("Game is finished");
            }
        }

    }

    public void UpdateBoard() {
        ArrayList<JLabel> VCells = v.getCells();
        ArrayList<Cell> MCells = m.getCells();
        for (int i = 0; i < VCells.size(); i++) {
            char status = MCells.get(i).getValue();
            if(status == 'N'){
                VCells.get(i).setText("");
            }
            else{
                VCells.get(i).setText(String.valueOf(status));
                VCells.get(i).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }

}

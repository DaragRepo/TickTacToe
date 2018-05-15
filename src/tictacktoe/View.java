/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author moh
 */
public class View {

    private Controller C;
    private JFrame Frame;
    private JPanel TicTacToe;
    private ArrayList<JLabel> Cells;
    private JLabel PlayerLetter;
    private JLabel Result;

    public View() {
        Frame = new JFrame("Tic Tac Toe");
        BorderLayout FrameLayout = new BorderLayout();
        FrameLayout.setVgap(20);
        Frame.setLayout(FrameLayout);
        Frame.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Frame.setLocation(dim.width / 2 - Frame.getSize().width / 2, dim.height / 2 - Frame.getSize().height / 2);
        Frame.setResizable(false);

        Cells = new ArrayList<>();
        JLabel cell;
        TicTacToe = new JPanel(new GridLayout(3, 3));
        PlayerLetter = new JLabel("You Won");
        Result = new JLabel("Second Label ");
        TicTacToe.setSize(new Dimension(100, 100));
        for (int i = 0; i < 9; i++) {
            cell = new JLabel();
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            cell.setBorder(border);
            cell.setHorizontalAlignment(JLabel.CENTER);
            cell.setVerticalAlignment(JLabel.CENTER);
            cell.setFont(new Font("Courier New", Font.BOLD, 35));
            cell.setText("O");
            TicTacToe.add(cell);
            Cells.add(cell);
        }

        PlayerLetter.setHorizontalAlignment(JLabel.CENTER);
        Result.setHorizontalAlignment(JLabel.CENTER);

        Frame.add(TicTacToe, BorderLayout.CENTER);
        Frame.add(PlayerLetter, BorderLayout.NORTH);
        Frame.add(Result, BorderLayout.SOUTH);

        Frame.setVisible(true);
        int i = 0;
        for (JLabel label : Cells) {
            final int ii = i;
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    C.RequestFillingCell(ii);
                }

                public void mouseEntered(MouseEvent e) {
                    C.adaptCellCursor(label, ii);
                }

            });
            i++;
        }
    }

    public void setController(Controller c) {
        C = c;
    }
    
    public ArrayList<JLabel> getCells(){
        return(Cells);
    } 

}

package tictacktoe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author moh
 */
public class GUI {

    JFrame Frame = new JFrame("Tic Tac Toe");
    private JPanel TicTacToe;
    private ArrayList <JLabel> labels;
    private JLabel PlayerLetter;
    private JLabel Result;

    public GUI() {

        BorderLayout FrameLayout = new BorderLayout();
        FrameLayout.setVgap(20);
        Frame.setLayout(FrameLayout);
        Frame.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Frame.setLocation(dim.width / 2 - Frame.getSize().width / 2, dim.height / 2 - Frame.getSize().height / 2);
        Frame.setResizable(false);

     
        TicTacToe = new JPanel(new GridLayout(3, 3));
        PlayerLetter = new JLabel("You Won");
        Result = new JLabel("Second Label ");
        TicTacToe.setSize(new Dimension(100, 100));
        
        labels =addLabels(TicTacToe,"","","","","","","","","");
        labels.get(5).setText("X");
        
        
        PlayerLetter.setHorizontalAlignment(JLabel.CENTER);
        Result.setHorizontalAlignment(JLabel.CENTER);

        Frame.add(TicTacToe, BorderLayout.CENTER);
        Frame.add(PlayerLetter, BorderLayout.NORTH);
        Frame.add(Result, BorderLayout.SOUTH);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);

    }

    // takes the panel ,  n from labels as a parameter and returns an array list of labels 

    private static ArrayList<JLabel> addLabels(Container container, String... s) {
        
        ArrayList<JLabel> cells = new ArrayList<>();
        JLabel cell;
        for (String labels : s) {
            cell = new JLabel(labels,SwingConstants.CENTER);
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            cell.setBorder(border);
            container.add(cell);
            cells.add(cell);
        }

        return cells;

    }

}

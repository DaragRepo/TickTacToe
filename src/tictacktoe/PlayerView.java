
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.awt.BorderLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author moh
 */
public class PlayerView extends JFrame implements ActionListener {

    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Active Players");
    JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
     DefaultListModel listModel = new DefaultListModel();
    private Object[] colNames = {};
    private JScrollPane scroll;
    private String selectedPlayer;
    private JList list = new JList(colNames);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
    private JButton startGame = new JButton("Start Game");

    public PlayerView() {
        this.scroll = new JScrollPane(list);
        setTitle("Active Players");
        setSize(300, 300);
        setSettings();
        addComponents();
        addingMouseListener();
        addEvent();
        setResizable(false);
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(container);
        add(bottombtnPnl, BorderLayout.SOUTH);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void addComponents() {
        container.add(Box.createVerticalStrut(15));
        container.add(label);
        container.add(Box.createVerticalStrut(20));
        container.add(scroll);
        bottombtnPnl.add(startGame);
    }

    private void setSettings() {

        label.setFont(new Font("Serif", Font.BOLD, 25));
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void addRowToJTable(ArrayList<String> ai) {
       
        for (int i = 0; i < ai.size(); i++) {
            listModel.addElement(ai.get(i));
        }
        list.setModel(listModel);
    }

    private void addingMouseListener() {
        list.addListSelectionListener(
                new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        selectedPlayer = (String) list.getSelectedValue();
                    }
                }
        );
    }

    private void addEvent() {
        startGame.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getSelectedPlayer() != null) {
            if (e.getSource() == startGame) {
                System.out.println(getSelectedPlayer());
                GUI gui = new GUI();
                dispose();
            }
        }

    }

    public String getSelectedPlayer() {
        return this.selectedPlayer;
    }

    public static void main(String[] args) {
        PlayerView view = new PlayerView();
        ArrayList<String> ai = new ArrayList();
      ai.add("first");
      ai.add("second");
//        
        view.addRowToJTable(ai);
        System.out.println(view.colNames);
    }

}

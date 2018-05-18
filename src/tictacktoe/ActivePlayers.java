
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
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moh
 */
public class ActivePlayers extends JFrame implements ActionListener {

    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Active Players");
  JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private Object[] colNames = {"Players","Active"};
    private Object[] data = {};
    private JScrollPane scroll;
    private String selectedPlayer ;
    private JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    private JButton startGame = new JButton ("Start Game");
    public ActivePlayers() {
        this.scroll = new JScrollPane(table);
        setTitle("Active Players");
        setSize(300, 300);
        setSettings();
        addComponents();
        addingMouseListener();
        addEvent();
        setResizable(false);
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(container);
        add(bottombtnPnl,BorderLayout.SOUTH);
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
        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setFillsViewportHeight(true);
        model.setColumnIdentifiers(colNames);
        table.setModel(model);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
        table.setFont(new Font("Serif", Font.BOLD, 15));
         table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 20));
        table.setDefaultEditor(Object.class, null);
    }
    
    public void addRowToJTable(ArrayList<Record> ai) {
        Object[] rowdata = new Object[3];
        for (int i = 0; i < ai.size(); i++) {
            rowdata[0] = ai.get(i).getPlayerOne();
            rowdata[1] = ai.get(i).getPlayerTwo();
            rowdata[2] = ai.get(i).getWinner();
            model.addRow(rowdata);
        }

    }
    
    private void addingMouseListener () {
        table.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
               int row = table.rowAtPoint(e.getPoint());
               selectedPlayer =(String) table.getValueAt(row, 0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    private void addEvent () {
        startGame.addActionListener(this);
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {
        if (getSelectedPlayer() != null) {
            if (e.getSource() == startGame) {
                GUI gui= new GUI ();
                dispose();
            }
        }
        
       
    }
    
    public String getSelectedPlayer () {
        return this.selectedPlayer;
    }
    
    
 
    public static void main (String[] args) throws SQLException {
        
        ArrayList <Record> records= new ArrayList ();
        Record record1 = new Record ("first","Active","6");
        Record record2 = new Record ("second","Active","6");
        Record record3= new Record ("third","Active","6");
     records.add(record1);
     records.add(record2);
     records.add(record3);
     
       
        
        ActivePlayers player =new ActivePlayers();
        player.addRowToJTable(records);
     
    }

  

}

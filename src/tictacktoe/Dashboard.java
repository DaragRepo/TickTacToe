/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author moh
 */
public class Dashboard extends JFrame implements ActionListener {

    private JPanel container = new JPanel();
    private JButton activePlayers  = new JButton ("Active Players");
    private JButton showHistory = new JButton ("Show History");
    private JButton logout = new JButton ("Logout");

    public Dashboard() {
        setTitle("Dashboard");
        setSize(400, 400);

        setLayoutManager();
        setLocationAndSize();
        addComponents();
        addActionEvent();

        setResizable(false);

        add(container);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void setLayoutManager() {
        container.setLayout(null);
       
    }

    private void addComponents() {
        container.add(activePlayers);
        container.add(showHistory);
        container.add(logout);
    }

    private void setLocationAndSize() {   
       activePlayers.setBounds(80, 80, 250, 50);
        showHistory.setBounds(80, 150, 250, 50);
             logout.setBounds(80, 230, 250, 50);

    }

    private void addActionEvent() {
        activePlayers.addActionListener(this);
        showHistory.addActionListener(this);
        logout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == activePlayers) {
            ArrayList <PlayerModel> records = new ArrayList();
            PlayerModel model = new PlayerModel ("Mohamed","Active");        
            PlayerModel model2 = new PlayerModel ("Ahmed","Busy");
            PlayerModel model3 = new PlayerModel ("Darag","Active");
            records.add(model);
            records.add(model2);
            records.add(model3);
            PlayerView view = new PlayerView();
            PlayerController controller = new PlayerController (model,view);
            controller.setActive(records);
            dispose ();
        } 
        
        if (e.getSource() == showHistory) {
      
            try {
                RecordModel model;
                model = new RecordModel();
                RecordViewer view = new RecordViewer();
                RecordController controller = new RecordController (model,view);
                controller.setRecord();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
        
        if (e.getSource() == logout) {
            dispose();
        }
        
        
    }

  public static void main (String[] arags) {
      Dashboard dash = new Dashboard();
  }

}

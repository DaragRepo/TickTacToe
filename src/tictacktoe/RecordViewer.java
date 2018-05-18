/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
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
public class RecordViewer extends JFrame implements ActionListener{
    
  private JPanel container = new JPanel();
  private JLabel label = new JLabel ("Game Records",SwingConstants.CENTER);

  
  private Object[] colNames = {"Player One", "Player Two", "Winner"};
//  DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
 
  private Object [] data = {};
  private JScrollPane scroll;
  private JTable table = new JTable (); 
  DefaultTableModel model = new DefaultTableModel ();
//  DefaultTableModel model = (DefaultTableModel) table.getModel();
//   DefaultTableModel tableModel  = (DefaultTableModel) table.getModel();
    public RecordViewer() {
        this.scroll = new JScrollPane(table);
        setTitle("Game Records");
        setSize(400, 400);

       
        setSettings();
        addComponents();
        addActionEvent();
        setResizable(false);
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(container);
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

   

    private void addComponents() {
        container.add(Box.createVerticalStrut(15));
        container.add(label);
        container.add(Box.createVerticalStrut(20));
        container.add(scroll);
    }

    private void setSettings() {  
 
        label.setFont(new Font("Serif", Font.BOLD, 25));
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);
        model.setColumnIdentifiers(colNames);
        table.setModel(model);
       ((DefaultTableCellRenderer)table.getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
        
    }
   

    private void addActionEvent() {
//        activePlayers.addActionListener(this);
//        showHistory.addActionListener(this);
//        logout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
   public void addRowToJTable(ArrayList<Record> ai)
    {
        Object [] rowdata = new Object [3];
        for (int i = 0 ; i < ai.size() ; i++) {
            rowdata[0] = ai.get(i).getPlayerOne();
            rowdata[1] = ai.get(i).getPlayerTwo();
            rowdata[2] = ai.get(i).getWinner();
            model.addRow(rowdata);
        }
                
    }

    public static void main(String[] args) {
       RecordViewer gr = new RecordViewer();
    }

}

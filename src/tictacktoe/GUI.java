/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author moh
 */
public class GUI  extends JFrame {
    
    private JPanel panel ;
    private JButton btn;
    private JLabel label ; 
    private JLabel label2 ; 
    private JPanel panel2;
    public GUI () {
        
        setSize(500,500);
        setTitle("Tic Tack Toe Game");
        panel = new JPanel(new GridLayout(3,3));
        label = new JLabel ("You Won");
        label2 = new JLabel ("Second Label ");
        panel.setPreferredSize(new Dimension(400,400));
        for(int i=0; i<9; i++){
            btn = new JButton();
            panel.add(btn);
        }
        

        label.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        add(panel, BorderLayout.CENTER);
        add(label,BorderLayout.NORTH);
        add(label2,BorderLayout.SOUTH);
//        panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//        setLayout(new FlowLayout());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    
    
    
}

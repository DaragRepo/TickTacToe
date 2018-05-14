/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

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
    private JButton btn1 ; 
    private JButton btn2 ; 
    private JButton btn3 ; 
    private JButton btn4 ; 
    private JButton btn5 ; 
    private JButton btn6 ; 
    private JButton btn7 ; 
    private JButton btn8 ; 
    private JButton btn9 ; 
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
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
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

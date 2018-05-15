/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author moh
 */
public class Login extends JFrame {

    private JLabel userName;
    private JLabel password;
    private JTextField name;
    private JTextField pass;
    private JPanel panel;

    public Login() {

        setSize(400, 400);
        setTitle("Login");
        panel = new JPanel();
        userName = new JLabel("username");
        panel.add(userName);
        name = new JTextField("");
        panel.add(name);
        password = new JLabel("password");
        panel.add(password);
        pass = new JTextField("");
        panel.add(pass);

        add(panel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}

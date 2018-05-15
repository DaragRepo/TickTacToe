/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author moh
 */
public class Login extends JFrame implements ActionListener {

    private JLabel userName = new JLabel("username");
    private JLabel password = new JLabel("password");
    private JTextField name = new JTextField();
    private JPasswordField pass = new JPasswordField();
    private JButton login = new JButton("Login");
    private JButton register = new JButton("Register");
    private JPanel panel = new JPanel();

    public Login() {

        setSize(400, 400);
        setTitle("Login");
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        add(panel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 370, 600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void setLayoutManager() {
        panel.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each components using setBounds() method.
        userName.setBounds(50, 150, 100, 30);
        password.setBounds(50, 220, 100, 30);
        name.setBounds(150, 150, 150, 30);
        pass.setBounds(150, 220, 150, 30);
        login.setBounds(50, 300, 100, 30);
        register.setBounds(200, 300, 100, 30);

    }

    public void addComponentsToContainer() {
        //Adding each components to the Container
        panel.add(userName);
        panel.add(password);
        panel.add(name);
        panel.add(pass);
        panel.add(login);
        panel.add(register);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if the user clicked login check the controller function if the password and username matches the database 
        if (e.getSource() == login) {

        }
        if (e.getSource() == register) {
            setVisible(false);
            Register register = new Register();
        }
    }

    public void addActionEvent() {
        //adding Action listener to components
        login.addActionListener(this);
        register.addActionListener(this);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moh
 */
public class RegisterController implements ActionListener {
    RegisterModel model ; 
    Register view ;

    public RegisterController(RegisterModel model, Register view) {
        this.model = model;
        this.view = view;
        addActionEvent();
    }
    
    public boolean register () {
       String name = view.getName();
       String email = view.getEmail();
       String password = view.getPassword();
       
       if (model.Register(name, password, email)) {
           return true ;
       } else {
           return false ;
       }
        
        
        
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {
          System.out.println("hey");
        // if the user clicked login check the controller function if the password and username matches the database 
        if (e.getSource() == view.register) {
             if (view.getEmail().equals("") || view.getPassword().equals("") || view.getName().equals("")) {
                 view.showOptionPane("Please Fill in All the required Fields");
             } else {
                 if (register()) {
                     view.showOptionPane("User Registered Succesfully");
                     view.setVisible(false);
                     try {
                         LoginModel model = new LoginModel();
                         Login view = new Login(); 
                         LoginController login = new LoginController (model,view);
                         login.login();
                     } catch (SQLException ex) {
                         Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                     }
           
                 } else {
                      view.showOptionPane("Error Inserting New User");
                 }
                 
             }
        }
    }
 
    
     public void addActionEvent() {
        //adding Action listener to components
        view.register.addActionListener(this);
    }
    
    
}

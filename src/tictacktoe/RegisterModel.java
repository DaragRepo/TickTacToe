/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.sql.SQLException;

/**
 *
 * @author moh
 */
public class RegisterModel {
    private Database db  ;
    
     public RegisterModel () throws SQLException {
         db = new Database ("jdbc:mysql://localhost:3307/ticktactoe", "root", "","user");
    }
     
     public boolean Register (String name , String password , String email) {
         if (db.insert(name,password,email)){
             return true ;
         } else {
             return false ;
         }
     }
     
}

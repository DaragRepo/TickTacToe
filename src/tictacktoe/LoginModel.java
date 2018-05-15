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
public class LoginModel {
    private Database db ; 
    public LoginModel () throws SQLException {
         db = new Database ("jdbc:mysql://localhost:3307/ticktactoe", "root", "","user");
    }
    public boolean login (String email , String password) throws SQLException {
        return db.selectLogin(email, password);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author moh
 */
public class TicTackToe {

    /**
     * @param args the command line arguments
     */
 
    
    public static void main(String[] args) throws SQLException {
   
        Database db =  new Database("jdbc:mysql://localhost:3307/ticktactoe", "root", "","user");
        System.out.println(db.selectRecord(1, 2));
//        System.out.println(db.getTableColumns());
//        db.insert("Mohamed","1234","mohameddarag1996@gmail.com");
//        System.out.println(db.getTableColumns());
//        db.insert("");
//        Login login = new Login ();   
//        Register reg = new Register ();
//        GUI gui = new GUI();
    }

}

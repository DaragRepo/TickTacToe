/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author moh
 */
public class Database {
    
    private String db_url;
    private String db_user;
    private String db_pass;
    private Connection conn;
    private String table_name;
    // establish the Database Connection 
    public Database(String db_url, String db_user, String db_pass,String table_name) throws SQLException {
        this.db_url = db_url;
        this.db_user = db_user;
        this.db_pass = db_pass;
        this.table_name = table_name;
        this.conn = DriverManager.getConnection(this.db_url, this.db_user, this.db_pass);
    }
    
    // insert into the Database 
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author moh
 */
public class RecordModel {
    Database db ;

    public RecordModel() throws SQLException {
         db = new Database ("jdbc:mysql://localhost:3307/ticktactoe", "root", "","record");
    }
    
    
      public ArrayList<Record> getRecords () throws SQLException {
          return db.select();
    }
    
    
    
 
    
}

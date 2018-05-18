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
public class RecordController {
    
    private RecordModel model ;
    private RecordViewer view ;

    public RecordController(RecordModel model, RecordViewer view) {
        this.model = model;
        this.view = view;
    }
    
    
    public void setRecord () throws SQLException {
        
      ArrayList <Record> record = model.getRecords();
      view.addRowToJTable(record);
        
        
        
    }
    
    public static void main (String[] main) throws SQLException {
      
    }
    
    
    
}

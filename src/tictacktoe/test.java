
import Model.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fake
 */
public class test {
    
    public static void main(String[] args) {
        Model m = new Model("islam","ahmed");
        View v = new View();
        Controller c = new Controller(m,v);
        v.setController(c);
        
        
    }
    
}

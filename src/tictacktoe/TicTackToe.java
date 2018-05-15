/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

/**
 *
 * @author moh
 */
public class TicTackToe {

    /**
     * @param args the command line arguments
     */
    public static void test (String... s) {
       for (int i = 0 ; i < s.length ; i++ ){
           System.out.println(s[i]);
       }
    }
    
    
    public static void main(String[] args) {
//        Login login = new Login ();
        test("1","2","3","4");
        
//        Register reg = new Register ();
//        GUI gui = new GUI();
    }

}

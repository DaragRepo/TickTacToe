package tictacktoe;



import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fake
 */
public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
            ModelInferface m = (ModelInferface) Naming.lookup("rmi://localhost/ModelInferface");
            View v = new View();
            
            Controller c = new Controller(m, v);
            v.setController(c);
        } catch (Exception e) {
            System.out.println("test");
            System.out.println("HelloClient exception: " + e);
        }

    }

}

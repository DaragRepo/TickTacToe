/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author moh
 */
public class BinaryFiles implements Serializable {

    private static String fileName = "data.ser";

//    public BinaryFiles(String fileName) throws IOException {
//        this.fileName = fileName + ".ser";
//    }

    public static String read() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        String s = (String) in.readObject();
        return s;
    }

    public static void write(String data) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(data);
        oos.flush();
        oos.close();
    }

}

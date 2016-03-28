/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author norazrina
 */
public class Code1 {

    /**
     * @param args the command line arguments
     */
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static void main(String[] args) throws FileNotFoundException {
        FileWriter out = null;
        
        String n;
        String a;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter your name: ");
        n = in.nextLine();
        
        System.out.println("Please enter your address: ");
        a = in.nextLine();
        System.lineSeparator();
        System.out.println("Your name is : "+n);
        System.out.println("Address is : "+a);
        //write file from yourname.txt
               try {
            out = new FileWriter("yourname.txt");
            out.write("Yourname: "+n);
            out.write(System.lineSeparator());
            out.write("Address: "+a);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Code1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //read file from yourname.txt
        File file = new File("yourname.txt");
        
        Scanner sc = new Scanner(file);
        String binToString = "";
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            byte[] bytes = line.getBytes(UTF_8);
            for(byte b : bytes){
                binToString += Integer.toBinaryString(b & 127 | 128).substring(1);
            }
            binToString += System.lineSeparator();
        }
        //write in binary to yourname.bin
        try {
            out = new FileWriter("yourname.bin");
            out.write(binToString);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Code1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //read from yourname.bin
        File file2 = new File("yourname.bin");
        
        Scanner sc2 = new Scanner(file2);
        
        String StoB = "";
        while(sc2.hasNextLine()){
            String line = sc2.nextLine();
            int interval = 7;
            int arrayLength = (int) Math.ceil(((line.length()/(double)interval)));
            String[] result = new String[arrayLength];
            
            int j = 0;
            int lastIndex = result.length - 1;
            for(int i = 0; i<=lastIndex; i++){
                result[i] = line.substring(j, j+interval);
                StoB +=  (char)Integer.parseInt( result[i], 2 );
                j += interval;
            }
            result[lastIndex] = line.substring(j);
            StoB += System.lineSeparator();
        }
        //write the binary to text to convert.txt
        try {
            out = new FileWriter("convert.txt");
            out.write(StoB);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(code1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
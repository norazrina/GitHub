/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code1;
import java.io.*;
/**
 *
 * @author norazrina
 */
public class Code1 {

    /**
     * @param args the command line arguments
     */
    
 public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "yourname.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("NORAZRINA BINTI MOHD YUSOF");
            bufferedWriter.newLine();
            bufferedWriter.write("PANGSAPURI SRI MELEWAR, SHAH ALAM");
          
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}

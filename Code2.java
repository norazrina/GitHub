/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author norazrina
 */
public class Code2 {

 public static void main(String[] args) throws IOException {


    // File to read.
    Path fileIn = Paths.get("yourname.txt");
    // File to write in binary
    String fileout = "yourname.bin";
    // Read text file using Files.*
    byte[] buffer = Files.readAllBytes(fileIn);

     // Write from the buffer
     try ( // Use stream for binary write
             FileOutputStream outputStream = new FileOutputStream(fileout)) {
         // Write from the buffer
         outputStream.write(buffer);
         // Close file
     }

    System.out.println("Wrote " + buffer.length + " bytes");
  }

}
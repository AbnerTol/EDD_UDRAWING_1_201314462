/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Brown
 */
public class Graphviz {

    public void RunBat() {
        try {
            //Este es de Brown
            //Process p = Runtime.getRuntime().exec("\"D:\\Users\\Brown\\Documents\\Graphviz\\test2.bat\"");
            //Este es de NK497JB
            Process p = Runtime.getRuntime().exec("\"C:\\Users\\NK497JB\\Documents\\Graphviz\\test2-nk497jb.bat\"");
        } catch (Exception e) {

        }
    }
    
    public void OpenImage() {
        try {
            //Este es de Brown
            //Process p = Runtime.getRuntime().exec("\"D:\\Users\\Brown\\Documents\\Graphviz\\test2.bat\"");
            //Este es de NK497JB
            Process p = Runtime.getRuntime().exec("\"C:\\Users\\NK497JB\\Documents\\Graphviz\\test2-OpenImage-nk497jb.bat\"");
        } catch (Exception e) {

        }
    }

    public void DeleteImage() {
        try {
            //Este es de Brown
            //Process p = Runtime.getRuntime().exec("\"D:\\Users\\Brown\\Documents\\Graphviz\\test2.bat\"");
            //Este es de NK497JB
            Process p = Runtime.getRuntime().exec("\"C:\\Users\\NK497JB\\Documents\\Graphviz\\test2-DeleteImage-nk497jb.bat\"");
        } catch (Exception e) {

        }
    }
    
    public void WriteFile( String comando ) {
        
        try {

            //Este es de Brown
            //FileWriter myWriter = new FileWriter("D:\\Users\\Brown\\Documents\\Graphviz\\ejemplo1.dot");
            
            //Este es de NK497JB
            FileWriter myWriter = new FileWriter("C:\\Users\\NK497JB\\Documents\\Graphviz\\ejemplo1.dot");
                       
            myWriter.write("" + comando );
            myWriter.close();
            

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package runfiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Brown
 */
public class RunFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        WriteFile();
        RunBat();
        
    }
    
    public static void RunBat()
    {
        try
        {
            Process p = Runtime.getRuntime().exec("\"D:\\Users\\Brown\\Documents\\Graphviz\\test2.bat\"");
        }
        catch(Exception e)
        {
            
        }
    }
    
    public static void WriteFile()
    {
        String text = "digraph ejemplo1\n"
                + "{\n"
                + "    rankdir =LR\n"
                + "    Nodo0[label=\"First\"];\n"
                + "    Nodo1[label=\"Second\"];\n"
                + "    Nodo2[shape=box, color=blue];\n"
                + "    Nodo3[shape=tab,style=filled,fillcolor=red];\n"
                + "\n"
                + "    Nodo0 -> Nodo1;\n"
                + "    Nodo1 -> Nodo2;\n"
                + "    Nodo3 -> Nodo1;\n"
                + "}";
        try {
            //File myObj = new File("D:\\Users\\Brown\\Documents\\Graphviz\\filename.dot");
            FileWriter myWriter = new FileWriter("D:\\Users\\Brown\\Documents\\Graphviz\\ejemplo1.dot");
            myWriter.write("" + text);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

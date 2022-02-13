/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udrawingpaper;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Brown
 */
public class UDrawingPaper {

    /**
     * @param args the command line arguments
     */    
    //Constructor
    public void UDrawinPaper()
    {     

    }
    
    public static void main(String[] args) {
        
        Paso paso = new Paso();
                
        int opcion=0;

                
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Cargar Lista de usuarios (TEMP)\n2.Crear ventanillas \n7.Ejecutar Paso\n11.Salir"));

                switch (opcion) {
                    
                    //Cargar Json
                    case 1:
                        paso.CrearUsuarios();
                    break;
                    //2.Crear Ventanillas
                    case 2:
                        int numeroVentanillas = Integer.parseInt( JOptionPane.showInputDialog(null, "Ingrese el número de ventanillas: ", "Insertando", 3) );

                        paso.CrearVentanillas( numeroVentanillas);
                        
                    break;
                    
                    //Paso
                    case 7:
                        try {
                        
                        paso.EjecutarPaso();
                            
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                    break;
                    

                        
                    case 11:

                        break;
                }
            } catch (Exception e) {

            }

        } while (opcion != 11);
        
    }
    

    
    
    
}

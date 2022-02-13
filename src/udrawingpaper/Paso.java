/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

import java.util.Random;

/**
 *
 * @author Brown
 */
public class Paso {

    int numeroDePasos = 0;
    ListaColaRecepcion colaRecepcion = new ListaColaRecepcion();
    ReadJsonFile users = new ReadJsonFile();
    
    

    int NumeroPasos = 0;

    public void EjecutarPaso() {

        NumeroPasos++;
        
        System.out.print("\n\n\n\n\n\n\n\n\n");
        System.out.println("_____________________________________________________________________________________________________________________________________________________");
        System.out.println("                                                                       Paso " + NumeroPasos + "                                                      ");
        System.out.println("_____________________________________________________________________________________________________________________________________________________");
        
        AgregarUsuarioAColaRecepción();
    }

    public void AgregarUsuarioAColaRecepción()
    {
        Random random = new Random();
        String temp1[] = users.GetUser(random.nextInt(9) + 1);

        Integer.parseInt(temp1[0]);
        Usuario usuario1 = new Usuario(Integer.parseInt(temp1[0]), temp1[1], Integer.parseInt(temp1[2]), Integer.parseInt(temp1[3]));

        colaRecepcion.insertarPrincipio(usuario1);

    }
    // Ejecuta el método de la clase ReadJsonFile
    public void CrearUsuarios() {
        users.CreateUsers();
    }
    
    public void CrearVentanillas( int cantidad )
    {
        
    }

}

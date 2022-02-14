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
    
    ListaVentanillas listaVentanillas = new ListaVentanillas();
    

    int NumeroPasos = 0;

    public void EjecutarPaso() {

        NumeroPasos++;
        
        System.out.print("\n\n\n\n\n\n\n\n\n");
        System.out.println("_____________________________________________________________________________________________________________________________________________________");
        System.out.println("                                                                       Paso " + NumeroPasos + "                                                      ");
        System.out.println("_____________________________________________________________________________________________________________________________________________________");
        
        AgregarUsuarioAColaRecepción();

        hacerPasarSiguienteUsuarioAVentanilla();
        
        
    }

    // Ejecuta el método de la clase ReadJsonFile
    public void CrearUsuarios() {
        users.CreateUsers();
    }
    
    public void AgregarUsuarioAColaRecepción()
    {
        Random random = new Random();
        String temp1[] = users.GetUser(random.nextInt(9) + 1);

        Integer.parseInt(temp1[0]);
        Usuario usuario1 = new Usuario(Integer.parseInt(temp1[0]), temp1[1], Integer.parseInt(temp1[2]), Integer.parseInt(temp1[3]));

        colaRecepcion.insertarFinal(usuario1);

    }
    
    //Este servirá para ir a buscar el siguiente usuario en la Cola de recepción. Este se unirá a
    public void hacerPasarSiguienteUsuarioAVentanilla()
    {
        if( colaRecepcion.tamañoLista()>0 )
        {
                       
            if( listaVentanillas.verificarSiHayVentanillaLibre() )
            {
                Usuario temp1 = colaRecepcion.eliminarPrimerCliente();
                System.out.println("Info usuario: " + temp1.getAllInfo());
                listaVentanillas.ingresarAVentanillaLibre( temp1 );
                
            }
            else
            {
                System.out.println("No existen ventanillas disponibles, espere un momento.");
            }
            
        }
    }
    
    public void CrearVentanillas( int cantidad )
    {

        try
        {
            for (int i = 1; i <= cantidad; i++) {
                Ventanilla ventanilla = new Ventanilla(i, null);
                listaVentanillas.insertarFinal(ventanilla);
            }
            
            System.out.println("Ventanillas creadas exitosamente");
            
        }
        
        catch( Exception e )
        {
            
        }
       
        
    }
        
    public void ImprimirListaUsuariosRecepcion()
    {
        colaRecepcion.imprimirLista();
    }
    
    public void ImprimirListaVentanillas()
    {
        listaVentanillas.imprimirLista();
    }
}

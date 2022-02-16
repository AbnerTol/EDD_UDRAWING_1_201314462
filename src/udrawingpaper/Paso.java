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

    int numeroDePasos;
    ListaColaRecepcion colaRecepcion;
    ReadJsonFile users;
    
    ListaVentanillas listaVentanillas;
    
    int NumeroPasos = 0;

    ListaClientesEnEspera listaClientesEnEspera = new ListaClientesEnEspera();
    
    //Constructor
    public Paso()
    {
        numeroDePasos = 0;
        users = new ReadJsonFile();
        colaRecepcion = new ListaColaRecepcion();
        listaVentanillas = new ListaVentanillas();
        listaVentanillas.setListaClientesEnEspera( listaClientesEnEspera );
    }
    
    public void EjecutarPaso() {

        NumeroPasos++;
        
        System.out.print("\n\n\n\n\n\n\n\n\n");
        System.out.println("_____________________________________________________________________________________________________________________________________________________");
        System.out.println("                                                                       Paso " + NumeroPasos + "                                                      ");
        System.out.println("_____________________________________________________________________________________________________________________________________________________");
        
        AgregarUsuarioAColaRecepción();

        hacerPasarSiguienteUsuarioAVentanilla();
        agregarImagenAVentanillasCorrespondientes();
        
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
    
    //Este servirá para ir a buscar el siguiente usuario en la Cola de recepción y agregarlo.
    public void hacerPasarSiguienteUsuarioAVentanilla()
    {
        if( colaRecepcion.tamañoLista()>0 )
        {
                       
            if( listaVentanillas.verificarSiHayVentanillaLibre() )
            {
                Usuario usuario = colaRecepcion.eliminarPrimerCliente();
                //System.out.println("Info usuario: " + usuario.getAllInfo());
                listaVentanillas.ingresarAVentanillaLibre( usuario );
                
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
                Ventanilla ventanilla = new Ventanilla(i, null, listaClientesEnEspera);
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
    
    public void agregarImagenAVentanillasCorrespondientes()
    {
        listaVentanillas.AgregarImagenAVentanilla();
    }
    
    public void ImprimirListaClientesEnEspera()
    {
        listaClientesEnEspera.imprimirLista();
    }
}

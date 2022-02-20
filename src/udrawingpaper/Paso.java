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
    ListaClientesAtendidos listaClientesAtendidos = new ListaClientesAtendidos();

    ListaClientesEnEspera listaClientesEnEspera = new ListaClientesEnEspera( listaClientesAtendidos );
    
    
    ImpresoraColor impresora1;
    ImpresoraByN impresora2;
    
    Graphviz grafica = new Graphviz();
    
    //Constructor
    public Paso()
    {
        numeroDePasos = 0;
        users = new ReadJsonFile();
        colaRecepcion = new ListaColaRecepcion();
        listaVentanillas = new ListaVentanillas();
        //listaVentanillas.setListaClientesEnEspera( listaClientesEnEspera );
        
        impresora1 = new ImpresoraColor( listaClientesEnEspera );
        impresora2 = new ImpresoraByN( listaClientesEnEspera );
    }
    
    public void EjecutarPaso() {

        NumeroPasos++;
        
        System.out.print("\n\n\n\n\n\n\n\n\n");
        System.out.println("#########################################################################################################################################################################################################");
        System.out.println("                                                                                            Paso " + NumeroPasos + "                                                      ");

        
        System.out.println("\n\n" + "____________________________________________________ Impresoras ______________________________________________________");
        impresora1.EnviarARespectivoCliente();
        impresora2.EnviarARespectivoCliente();
        System.out.println("____________________________________________________ //Impresoras ______________________________________________________");
        
        System.out.println("\n\n" + "____________________________________________________ Recepción ____________________________________________________");
        AgregarUsuarioAColaRecepción();
        System.out.println("____________________________________________________ //Recepción ____________________________________________________");

        System.out.println("\n\n" + "____________________________________________________ Ventanillas ______________________________________________________");
        agregarImagenAVentanillasCorrespondientes();
        hacerPasarSiguienteUsuarioAVentanilla();
        System.out.println("____________________________________________________ //Ventanillas ____________________________________________________");
        
        System.out.println("\n#########################################################################################################################################################################################################");
       
        
    }

    // Ejecuta el método de la clase ReadJsonFile
    public void CrearUsuarios() {
        users.CreateUsers();
    }
    
    public void AgregarUsuarioAColaRecepción()
    {
        Random random = new Random();
        String temp1[] = users.GetUser(random.nextInt(19) + 1);

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
                Ventanilla ventanilla = new Ventanilla(i, null, listaClientesEnEspera, impresora1, impresora2);
                listaVentanillas.insertarFinal(ventanilla);
            }
            
            System.out.println("Ventanillas creadas exitosamente");
            
        }
        
        catch( Exception e )
        {
            
        }
       
        
    }
     
    //________________________________________________________________________ Impresiones Consola/Graphviz _____________________________________________________________________________________
    
    public void ImprimirListaUsuariosRecepcion()
    {
        colaRecepcion.imprimirLista();        
        
        //String comando = colaRecepcion.construirComandoGrafo();       
        //grafica.WriteFile(comando);
        //grafica.RunBat();
        //grafica.OpenImage();
    }
    
    public void ImprimirListaVentanillas()
    {
        listaVentanillas.imprimirLista();
        
//        String comando = listaVentanillas.construirComandoGrafo1();
//        grafica.WriteFile(comando);
//        grafica.RunBat();
//        grafica.OpenImage();
    }
    
    public void agregarImagenAVentanillasCorrespondientes()
    {
        listaVentanillas.AgregarImagenAVentanilla();
    }
    
    public void ImprimirListaClientesEnEspera()
    {
        listaClientesEnEspera.imprimirLista();
        
        String comando = listaClientesEnEspera.construirComandoGrafo();
        
//        grafica.WriteFile(comando);
//        grafica.RunBat();
//        grafica.OpenImage();
    }
    
    public void ImprimirListaDeImagenesEnVentanilla()
    {
        listaVentanillas.imprimirListaDeImagenesEnVentanilla();
    }
    
    public void ConstruirGrafoVentanillaCompleta()
    {
        System.out.println( listaVentanillas.construirComandoGrafo2() );
    }
        
    public void ImprimirListaEnImpresoras()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        impresora1.imprimirLista();
        impresora2.imprimirLista();
    }
    
    public void ImprimirListaDeClientesAtendidos()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        listaClientesAtendidos.imprimirLista();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author NK497JB
 */
public class Reporte1 {
    
    //este va ser el único nodo para este reporte
    private Nodo cabeza;
    private int tamañoLista;

    private class Nodo {

        public Usuario usuario;
        public Nodo siguiente = null;
        int tamañoLista = 0;

        //Constructor
        public Nodo(Usuario usuario) {
            this.usuario = usuario;
        }
    }
    
    // _________________________________________________________________________Inserciones Usuario con Mayor cantidad de pasos________________________________________________________________________________
     
    //Este método verifica si el usuario recibido tiene más pasos que el actual en cabeza
    public void ValidarTop( Usuario usuario )
    {
        //Si no hay ningún usuario todavía 
        if( tamañoLista == 0 )
        {
            Nodo nodo = new Nodo(usuario);
            cabeza = nodo;
            cabeza.siguiente = null;
            tamañoLista++;
        }
        
        else
        {
            if (cabeza.usuario.getPasosRequeridos() < usuario.getPasosRequeridos()) {
                //insertarPrincipio(usuario);
                Nodo nodo = new Nodo(usuario);
                cabeza = nodo;
                cabeza.siguiente = null;
                tamañoLista++;
            }             
        }
    }
    
    public void MostrarUsuarioConMasPasos()
    {
        if( tamañoLista == 0 )
        {
            System.out.println("Aún no se atiende a ningún usuario");
        }
        
        else
        {
            System.out.println( "Clientes con mayor número de pasos: " + cabeza.usuario.getAllInfo() + " Con un total de " + cabeza.usuario.getPasosRequeridos() + "pasos" );
            
        }
    }
    
    public void insertarPrincipio(Usuario usuario) {
        Nodo nodo = new Nodo(usuario);
        nodo.siguiente = cabeza;
        cabeza = nodo;

        tamañoLista++;

        System.out.println("Nuevo usuario en cola de recepción: " + usuario.getAllInfo());
    }

    public void insertarFinal(Usuario usuario) {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;
            Nodo nodo = new Nodo(usuario);

            while (tempNodo.siguiente != null) {
                tempNodo = tempNodo.siguiente;
            }

            tempNodo.siguiente = nodo;
            tamañoLista++;
            System.out.println("Nuevo usuario en cola de recepción: " + usuario.getAllInfo());
        } else {
            Nodo nodo = new Nodo(usuario);
            cabeza = nodo;
            tamañoLista++;
            System.out.println("Nuevo usuario en cola de recepción: " + usuario.getAllInfo());
        }
    }
 
    
}

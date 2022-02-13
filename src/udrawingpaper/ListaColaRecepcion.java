/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;
import java.awt.Desktop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Brown
 */
public class ListaColaRecepcion{
    
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
    
    // _________________________________________________________________________Inserciones________________________________________________________________________________
    
    public void insertarPrincipio( Usuario usuario ) {
        Nodo nodo = new Nodo(usuario);
        nodo.siguiente = cabeza;
        cabeza = nodo;

        tamañoLista++;
        
        System.out.println("Nuevo usuario en cola de recepción: " + usuario.getAllInfo() );
    }
    
        // _________________________________________________________________________Imprimir Lista________________________________________________________________________________
    
    public void imprimirLista()
    {
        if(tamañoLista >=1)
        {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                System.out.println(tempNodo.usuario.getAllInfo());
                tempNodo = tempNodo.siguiente;
            }            
        }
        else
        {
            System.out.println("Lista vacía");
        }
         
    }
    
    public void grafo()
    {
        
    }
}

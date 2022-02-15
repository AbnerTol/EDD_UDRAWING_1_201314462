/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author Brown
 */

import java.awt.Desktop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListaImagen {
    
    private Nodo cabeza;
    private int tamañoLista;

    private class Nodo {

        public Imagen imagen;
        public Nodo siguiente = null;
        int tamañoLista = 0;

        //Constructor
        public Nodo( Imagen imagen ) {
            this.imagen = imagen;
        }
    }

    // _________________________________________________________________________Inserciones________________________________________________________________________________
    
    public void insertarPrincipio( Imagen imagen ) {
        Nodo nodo = new Nodo( imagen );
        nodo.siguiente = cabeza;
        cabeza = nodo;

        tamañoLista++;

        System.out.println("Imagen agregada: " + imagen.getAllInfo());
        
        System.out.print ("lista completa:  ");
        imprimirLista();
        
    }
    
    public void imprimirLista() {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                System.out.println(tempNodo.imagen.getAllInfo());
                tempNodo = tempNodo.siguiente;
            }
        } else {
            System.out.println("Lista vacía");
        }

    }
    
       
}

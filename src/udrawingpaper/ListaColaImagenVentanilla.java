/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

import java.awt.Desktop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListaColaImagenVentanilla {
    
    private Nodo cabeza;
    private int tamañoLista;


    private class Nodo {

        public ColaImagenVentanilla imagen;
        public Nodo siguiente = null;
        int tamañoLista = 0;

        //Constructor
        public Nodo( ColaImagenVentanilla imagen ) {
            this.imagen= imagen;
        }
    }   
    
    
    // _________________________________________________________________________Inserciones________________________________________________________________________________
    public void insertarPrincipio(ColaImagenVentanilla imagen) {
        ListaColaImagenVentanilla.Nodo nodo = new ListaColaImagenVentanilla.Nodo( imagen );
        nodo.siguiente = cabeza;
        cabeza = nodo;

        tamañoLista++;

        System.out.println("Nuevo usuario en cola de recepción: " + imagen.getAllInfo());
    }

    
}

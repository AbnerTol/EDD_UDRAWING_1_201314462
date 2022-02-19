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
 * @author NK497JB
 */
public class ImpresoraColor {    
          
    private Nodo cabeza;
    private int tamañoLista;
    private ListaClientesEnEspera listaClientesEnEspera;

    public ImpresoraColor(ListaClientesEnEspera listaClientesEnEspera) {
        this.listaClientesEnEspera = listaClientesEnEspera;
    }

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
        
    public void insertarFinal( Imagen imagen ) {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;
            Nodo nodo = new Nodo(imagen);

            while (tempNodo.siguiente != null) {
                tempNodo = tempNodo.siguiente;
            }

            tempNodo.siguiente = nodo;
            tamañoLista++;           
        } else {
            Nodo nodo = new Nodo(imagen);
            cabeza = nodo;
            tamañoLista++;
        }
    }
    
    public void EnviarARespectivoCliente() {
        if (tamañoLista > 0) {
            //Trae la referencia del primer Nodo
            Nodo tempNodo = cabeza;

            //envía la imagen (la referencia) hacia otro metodo para que le busque dueño en base a su código 
            listaClientesEnEspera.recibirImagenyBuscarlePropietario(tempNodo.imagen);
            //elimina el nodo anteriormente citado, asignado una nueva cabeza
            eliminar(1);
        }
    }

    public void eliminar(int posicion) {
        if (posicion > tamañoLista) {
            System.out.println("Error, número invalido.");
        } else {
            //Eliminar el primero
            if (posicion == 1) {
                this.cabeza = this.cabeza.siguiente;
                tamañoLista--;
            }
        }

    }
    
    
    public void imprimirLista() {

        System.out.println("Impresora 1 (Color): " + "[");
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                System.out.println(tempNodo.imagen.getAllInfo());
                tempNodo = tempNodo.siguiente;
            }
        } else {
            System.out.println("Lista vacía");
        }
        System.out.println("]");
    }
    
}

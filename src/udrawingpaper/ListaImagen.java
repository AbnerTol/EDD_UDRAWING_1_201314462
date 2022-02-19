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
    
    private ImpresoraColor impresora1;
    private ImpresoraByN impresora2;
    
    public ListaImagen( ImpresoraColor impresora1, ImpresoraByN impresora2 )
    {
        this.impresora1 = impresora1;
        this.impresora2 = impresora2;
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
            
            System.out.println("Imagen agregada[" + imagen.getAllInfo() + "]");        

            System.out.println("Tamaño de ListaImagen: " + this.tamañoLista);

            
        } else {
            Nodo nodo = new Nodo(imagen);
            cabeza = nodo;
            tamañoLista++;
            
            System.out.println("Imagen agregada[" + imagen.getAllInfo() + "]");        
            System.out.println("Tamaño de ListaImagen: " + this.tamañoLista);

        }
    }
    
    
    public void imprimirLista() {

        System.out.println("Impresión de Lista Imagen: " + "[");
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
    
    public void EnviarImagenesAImpresora()
    {

        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                
                if( tempNodo.imagen.getTipoImagen().equals("Color"))
                {
                    impresora1.insertarFinal( tempNodo.imagen );
                }
                
                else
                {
                    impresora2.insertarFinal(tempNodo.imagen);
                }
                
                tempNodo = tempNodo.siguiente;
            }
            
            System.out.println("IMPRESORAS:------------------------------");
            impresora1.imprimirLista();
            impresora2.imprimirLista();
            
            this.cabeza = null;
        } else {
            System.out.println("Lista vacía");
        }
        System.out.println("]");
    }
    
    // RESOLVER
    public String construirComandoGrafo( int n )
    {
        System.out.println("Valor de n recibida en Lista imagen: " + n );
        int contador = n;
        String comando = "";

        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {

                comando = comando + "\n" + "Nodo" + contador + "[" + "label=\"" + tempNodo.imagen.getTipoImagen() + "\",color=\"#40e0d0\", shape=box, style=filled, fillcolor=\"#1C0049\" , fontcolor=\"#FF0096\"];";
                tempNodo = tempNodo.siguiente;
                contador++;
            }

            tempNodo = cabeza;
            contador = n;
            //para crear las conexiones entre nodos
            while (tempNodo != null) {

                // si el siguiente es null significa que hemos llegado al final ingorando así una conexión innecesaria que crearía un nodo nuevo, que no tendría sentido
                if (tempNodo.siguiente == null) {
                    tempNodo = tempNodo.siguiente;
                    contador++;

                } else {
                    comando = comando + "\n" + "Nodo" + contador + " -> " + "Nodo" + (contador + 1) + ";";
                    tempNodo = tempNodo.siguiente;
                    contador++;

                }
            }

        } else {
            System.out.println("Lista vacía");

            comando = "";
        }

        //System.out.println("Comando generado desde ListaImagen: " + comando );
        return comando;
    }
       
}

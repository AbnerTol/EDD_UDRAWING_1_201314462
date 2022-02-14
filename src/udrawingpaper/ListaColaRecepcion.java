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
public class ListaColaRecepcion {

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
    // _________________________________________________________________________Eliminar________________________________________________________________________________

    //Este sirve para eliminar el primer cliente que llegó a cola de recepción, para ser enviado a la ventanilla disponible
    public Usuario eliminarPrimerCliente() {

        Usuario temp = this.cabeza.usuario;
        //Eliminar el primero
        this.cabeza = this.cabeza.siguiente;
        tamañoLista--;
        return temp;
    }

    // _________________________________________________________________________Imprimir Lista________________________________________________________________________________
    public void imprimirLista() {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                System.out.println(tempNodo.usuario.getAllInfo());
                tempNodo = tempNodo.siguiente;
            }
        } else {
            System.out.println("Lista vacía");
        }

    }

    public int tamañoLista() {
        return this.tamañoLista;
    }

    public void grafo() {

    }
}

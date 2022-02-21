/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author NK497JB
 */
public class Reportes {
    
    private Nodo Top1;
    
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
 // _________________________________________________________________________Inserciones Usuario con Mayor cantidad de pasos________________________________________________________________________________
  
    
}

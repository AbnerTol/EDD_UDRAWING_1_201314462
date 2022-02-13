/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author Brown
 */
public class ListaVentanillas {
    
    private Nodo cabeza;
    private int tamañoLista;


    private class Nodo {

        public Ventanilla ventanilla;
        public Nodo siguiente = null;
        int tamañoLista = 0;

        //Constructor
        public Nodo(Ventanilla ventanilla) {
            
            this.ventanilla = ventanilla;
        }
    }   
    
    public void insertarPrincipio( Ventanilla ventanilla ) {
        ListaVentanillas.Nodo nodo = new ListaVentanillas.Nodo( ventanilla );
        nodo.siguiente = cabeza;
        cabeza = nodo;

        tamañoLista++;

        System.out.println("Nueva ventanilla creada: " + ventanilla.getAllInfo());
    }
    
}

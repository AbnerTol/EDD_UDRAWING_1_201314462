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
    
//    public void insertarPrincipio( Ventanilla ventanilla ) {
//        Nodo nodo = new Nodo( ventanilla );
//        nodo.siguiente = cabeza;
//        cabeza = nodo;
//
//        tamañoLista++;
//
//        System.out.print("Nueva ventanillaaa: " + ventanilla.getAllInfo());
//    }
    
    public void insertarFinal( Ventanilla ventanilla  ) {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;
            Nodo nodo = new Nodo(ventanilla);

            while (tempNodo.siguiente != null) {
                tempNodo = tempNodo.siguiente;
            }

            tempNodo.siguiente = nodo;
            tamañoLista++;
        } else {
            Nodo nodo = new Nodo(ventanilla);
            cabeza = nodo;
            tamañoLista++;
        }
    }

    public void ingresarAVentanillaLibre( Usuario usuario )
    {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

                      
            while (tempNodo != null) {
                
                if( tempNodo.ventanilla.verificarUsuario()== null )
                {
                    tempNodo.ventanilla.recibirUsuario(usuario);
                    System.out.println("Ventanilla disponible: " + tempNodo.ventanilla.getAllInfo() );
                    System.out.println("Usuario que se envía a ventanilla: " + usuario.getAllInfo());
                    break;
                }

                else
                {
                    tempNodo = tempNodo.siguiente;             
                    
                }
            }
        } else {
            System.out.println("No existen ventanillas creadas");
        }
    }
    
    public boolean verificarSiHayVentanillaLibre()
    {
        boolean disponible = false;
        
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {

                if (tempNodo.ventanilla.verificarUsuario() == null) {
                    disponible = true;
                    break;
                } else {
                    tempNodo = tempNodo.siguiente;

                }
            }
        }         
        return disponible;
    }
    
    public void imprimirLista() {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                System.out.println(tempNodo.ventanilla.getAllInfo());
                tempNodo = tempNodo.siguiente;
            }
        } else {
            System.out.println("Lista vacía");
        }
    }
    
    public int tamañoLista()
    {
        return this.tamañoLista;
    }

}

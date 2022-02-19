/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author Brown
 */
public class ListaClientesEnEspera {
    
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
//    public void insertarPrincipio(Usuario usuario) {
//        Nodo nodo = new Nodo(usuario);
//        nodo.siguiente = cabeza;
//        cabeza = nodo;
//
//        tamañoLista++;
//
//        System.out.println("Nuevo usuario en cola de recepción: " + usuario.getAllInfo());
//    }

    public void insertarFinal(Usuario usuario) {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;
            Nodo nodo = new Nodo(usuario);

            while (tempNodo.siguiente != null) {
                tempNodo = tempNodo.siguiente;
            }

            tempNodo.siguiente = nodo;
            tamañoLista++;
            System.out.println("Nuevo usuario en LISTA DE ESPERA: " + usuario.getUserName());
        } else {
            Nodo nodo = new Nodo(usuario);
            cabeza = nodo;
            tamañoLista++;
            System.out.println("Nuevo usuario en LISTA DE ESPERA: " + usuario.getUserName());
        }
    }
    
    public void recibirImagenyBuscarlePropietario( Imagen imagen )
    {
        System.out.println("--TEMP-- IMAGEN RECIBIDA: ");
        System.out.println( imagen.getAllInfo() );
    }
    // _________________________________________________________________________Eliminar________________________________________________________________________________

    //Este sirve para eliminar el primer cliente que llegó a cola de recepción, para ser enviado a la lista de clientes atendidos
    public Usuario eliminarPrimerCliente() {

        Usuario temp = this.cabeza.usuario;
        //Eliminar el primero
        this.cabeza = this.cabeza.siguiente;
        tamañoLista--;
        return temp;
    }

    // _________________________________________________________________________Imprimir Lista________________________________________________________________________________
    public void imprimirLista() {
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Impresión de Lista de Espera: ");
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

    public String construirComandoGrafo() {

        int contador = 0;
        String comando = "digraph ejemplo1\n"
                + "{\n"
                + "    rankdir =LR\n";

        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {

                comando = comando + "\n" + "Nodo" + contador + "[" + "label=\"" + tempNodo.usuario.getUserName() + "\",color=\"#40e0d0\", style=filled, fillcolor=\"#1C0049\" , fontcolor=\"#FF0096\"];";
                tempNodo = tempNodo.siguiente;
                contador++;
            }

            tempNodo = cabeza;
            contador = 0;

            while (tempNodo != null) {

                if (tempNodo.siguiente == null) {
                    tempNodo = tempNodo.siguiente;
                    contador++;

                } else {
                    comando = comando + "\n" + "Nodo" + contador + " -> " + "Nodo" + (contador + 1) + ";";
                    tempNodo = tempNodo.siguiente;
                    contador++;

                }
            }

            comando = comando + "label = \"Clientes en Espera\";";
            comando = comando + "}";

        } else {
            System.out.println("Lista vacía");
            
            comando = "digraph ejemplo1\n"
                    + "{\n"
                    + "    rankdir =LR\n label = \"Clientes en Espera\";}";
        }

        return comando;
    }
    
}

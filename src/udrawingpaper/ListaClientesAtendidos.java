/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author NK497JB
 */
public class ListaClientesAtendidos {
    
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
    
    public void insertarFinal(Usuario usuario) {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;
            Nodo nodo = new Nodo(usuario);

            while (tempNodo.siguiente != null) {
                tempNodo = tempNodo.siguiente;
            }

            tempNodo.siguiente = nodo;
            tamañoLista++;
            System.out.println("Cliente Atendido: " + usuario.getUserName());
        } else {
            Nodo nodo = new Nodo(usuario);
            cabeza = nodo;
            tamañoLista++;
            System.out.println("Cliente Atendido: " + usuario.getUserName());
        }
    }
    
    public void imprimirLista() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------------------------------Clientes Atendidos-----------------------------------------: ");
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

                comando = comando + "\n" + "Nodo" + contador + "[" + "label=\"" + tempNodo.usuario.getUserName() + "\",color=\"#40e0d0\", style=filled, fillcolor=\"#8AC072\" , fontcolor=\"#005B8E\"];";
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

            comando = comando + "label = \"Clientes atendidos\";";
            comando = comando + "}";

        } else {
            System.out.println("Lista vacía");

            comando = "digraph ejemplo1\n"
                    + "{\n"
                    + "    rankdir =LR\n label = \"Clientes atendidos\";}";
        }

        return comando;
    }
    
}

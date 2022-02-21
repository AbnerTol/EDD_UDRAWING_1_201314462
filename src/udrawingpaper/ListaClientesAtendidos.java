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
    private Reporte1 reporte1;
    private Reporte2 reporte2;
    private Reporte3 reporte3;

    public ListaClientesAtendidos( Reporte1 reporte1, Reporte2 reporte2, Reporte3 reporte3 )
    {
        this.reporte1 = reporte1;
        this.reporte2 = reporte2;
        this.reporte3 = reporte3;
    }
    
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
            //Envía una copia de la referencia hacia reportes1 para que valide si es el nuevo top o no
            reporte1.ValidarTop( usuario );
            
            //reporte2.ValidarUsuarioEntrante( usuario );
            //reporte3.ValidarUsuarioEntrante( usuario );
            System.out.println("Cliente Atendido: " + usuario.getUserName());
        } else {
            Nodo nodo = new Nodo(usuario);
            cabeza = nodo;
            tamañoLista++;
            //Envía una copia de la referencia hacia reportes1 para que valide si es el nuevo top o no
            reporte1.ValidarTop(usuario);
            //reporte2.ValidarUsuarioEntrante(usuario);
            //reporte3.ValidarUsuarioEntrante( usuario );
            System.out.println("Cliente Atendido: " + usuario.getUserName());
        }
    }
    
    public void imprimirLista() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------------------------------Clientes Atendidos-----------------------------------------: ");
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                System.out.print(tempNodo.usuario.getAllInfo());
                System.out.println(", atendido en ventanilla " + tempNodo.usuario.getVentanillaQueAtendio() + " con un total de " + tempNodo.usuario.getPasosRequeridos() + " pasos");
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

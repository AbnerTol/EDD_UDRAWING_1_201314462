/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author NK497JB
 */
//Top 5 de clientes con Mayor número de imágenes impresas
public class Reporte2 {

    //Este reporte solo tendrá 3 nodos
    private Nodo cabeza1;
    private int tamañoLista1;

    //este es para la lista del top
    private Nodo cabeza2;
    private int tamañoLista2;

    private class Nodo {

        public Usuario usuario;
        public Nodo siguiente = null;
        int tamañoLista = 0;

        //Constructor
        public Nodo(Usuario usuario) {
            this.usuario = usuario;
        }
    }

    //recibe la cabeza de la lista de clientes atendidos, lo cual traería por ende toda la lista
    public void ValidarUsuarioEntrante(Usuario usuario) {
        //ingresa el usuario que vino, a la lista de clientes
        insertarFinal1(usuario);

//                
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//        System.out.println("LISTA RECIBIDA EN REPORTE2 ");
//        if (tamañoLista >= 1) {
//            Nodo tempNodo = cabeza;
//
//            while (tempNodo != null) {
//                System.out.println(tempNodo.usuario.getAllInfo());
//                tempNodo = tempNodo.siguiente;
//            }
//        } else {
//            System.out.println("Lista vacía");
//        }
    }

    public void EncontrarTop() {
        imprimirLista2();
    }

    public void eliminar(int posicion) {
        if (posicion > tamañoLista1) {
            System.out.println("Error, número invalido.");
        } else {
            //Eliminar el primero
            if (posicion == 1) {
                this.cabeza1 = this.cabeza1.siguiente;
                tamañoLista1--;
            } //Eliminar el último
            else if (posicion == tamañoLista1) {
                Nodo temp = cabeza1;
                for (int i = 1; i < tamañoLista1 - 1; i++) {
                    temp = temp.siguiente;
                }

                temp.siguiente = null;
                tamañoLista1--;

            } //Eliminar en medio
            else {
                int n = 1;
                Nodo temp1 = cabeza1;
                Nodo temp2 = null;

                while (temp1 != null) {
                    if (n < posicion) {
                        temp2 = temp1;
                        temp1 = temp1.siguiente;

                        System.out.println(n);
                    } else {
                        temp2.siguiente = temp1.siguiente;
                        System.out.println("Llegó al número solicitado, procediendo ...");
                        break;
                    }

                    n++;
                }

                tamañoLista1--;

            }
        }

    }

    //Este es para insertar a lista de usuarios atendidos
    public void insertarFinal1(Usuario usuario) {
        if (tamañoLista1 >= 1) {
            Nodo tempNodo = cabeza1;
            Nodo nodo = new Nodo(usuario);

            while (tempNodo.siguiente != null) {
                tempNodo = tempNodo.siguiente;
            }

            tempNodo.siguiente = nodo;
            tamañoLista1++;
            System.out.println("Nuevo usuario agregado desde reporte2 " + usuario.getAllInfo());
        } else {
            Nodo nodo = new Nodo(usuario);
            cabeza1 = nodo;
            tamañoLista1++;
            System.out.println("Nuevo usuario agregado desde reporte2 " + usuario.getAllInfo());
        }

        imprimirLista1();
    }

    //Este es para insertar a lista de usuarios atendidos
    public void insertarFinal2(Usuario usuario) {
        if (tamañoLista2 >= 1) {
            Nodo tempNodo = cabeza2;
            Nodo nodo = new Nodo(usuario);

            while (tempNodo.siguiente != null) {
                tempNodo = tempNodo.siguiente;
            }

            tempNodo.siguiente = nodo;
            tamañoLista2++;
            System.out.println("Top actualizado");
        } else {
            Nodo nodo = new Nodo(usuario);
            cabeza2 = nodo;
            tamañoLista2++;
            System.out.println("Top actualizado");
        }

        imprimirLista1();
    }

    public void getTop5() {
        imprimirLista2();
    }

    //Este para lista de usuarios atendidos
    public void imprimirLista1() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("    LISTA DE USUARIOS ATENDIDOS DESDE REPORTE2");
        if (tamañoLista1 >= 1) {
            Nodo tempNodo = cabeza1;

            while (tempNodo != null) {
                System.out.println(tempNodo.usuario.getAllInfo());
                tempNodo = tempNodo.siguiente;
            }
        } else {
            System.out.println("Lista vacía");
        }

    }

    //Este para lista del top
    public void imprimirLista2() {
        System.out.println("Tamaño lista 2: " + this.tamañoLista2);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Top 5 usuarios con mayor cantidad de imágenes a color");
        if (tamañoLista2 >= 1) {
            Nodo tempNodo = cabeza2;

            while (tempNodo != null) {
                System.out.println(tempNodo.usuario.getAllInfo());
                tempNodo = tempNodo.siguiente;
            }
        } else {
            System.out.println("Lista vacía");
        }

    }

}

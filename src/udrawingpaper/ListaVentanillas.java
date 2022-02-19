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
    private ListaClientesEnEspera listaClientesEnEspera;

    
    public ListaVentanillas() {
        //listaClientesEnEspera = new ListaClientesEnEspera();
    }

//    //Recibe la referencia hacia la lista de clientes en espera, creada en la clase Paso
//    public void setListaClientesEnEspera(ListaClientesEnEspera listaClientesEnEspera) {
//        this.listaClientesEnEspera = listaClientesEnEspera;
//    }


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
    //Crea una nueva ventanilla y la coloca al final
    public void insertarFinal(Ventanilla ventanilla) {
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

    //Ingresa un Usuario a la primer ventanilla que esté disponible
    public void ingresarAVentanillaLibre(Usuario usuario) {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {

                if (tempNodo.ventanilla.verificarUsuario() == null) {
                    System.out.print("Ventanilla disponible: " + tempNodo.ventanilla.getCodigoVentanilla() );
                    System.out.print(",Usuario enviado: " + usuario.getUserName() + ",");
                    tempNodo.ventanilla.recibirUsuario(usuario);
                    break;
                } else {
                    tempNodo = tempNodo.siguiente;

                }
            }
        } else {
            System.out.println("No existen ventanillas creadas");
        }
    }

    public boolean verificarSiHayVentanillaLibre() {
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

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Impresión de Lista Ventanillas: ");
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
    
    //Imprime las imágenes contenidas en cada ventanilla
    public void imprimirListaDeImagenesEnVentanilla()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                System.out.println(tempNodo.ventanilla.getAllInfo());
                System.out.println("------------Cadena de imágenes asociadas------------------");
                
                tempNodo.ventanilla.ImprimirListaImagenes();
                
                System.out.println("----------------------------------------------------------");
                tempNodo = tempNodo.siguiente;
            }
        } else {
            System.out.println("Lista vacía");
        }
    }

    public int tamañoLista() {
        return this.tamañoLista;
    }

    //___________________________________________________________________________________Imágenes_______________________________________________________________________________
    //Este método recorre las ventanillas, y en cada una, intenta agregar un nodo a su sub lista de imágenes
    public void AgregarImagenAVentanilla() {
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {

                try {
                    tempNodo.ventanilla.AgregarImagen();
                } catch (Exception e) {
                    System.out.println("Error en metodo AgregarImagenAVentanilla: " + e);
                }
                tempNodo = tempNodo.siguiente;
            }
        } else {
            System.out.println("No existen ventanillas");
        }

    }

    //Este método genera el comando para las ventanillas solamente
    public String construirComandoGrafo1() {

        int contador = 0;
        String comando = "digraph ejemplo1\n"
                + "{\n"
                + "    rankdir =LR\n";

        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            //Para crear los nodos
            while (tempNodo != null) {

                comando = comando + "\n" + "Nodo" + contador + "[" + "label=\"V " + tempNodo.ventanilla.getCodigoVentanilla() + ", U:" + tempNodo.ventanilla.getUserName() + "\",color=\"#40e0d0\", shape=box, style=filled, fillcolor=\"#1C0049\" , fontcolor=\"#FF0096\"];";
                tempNodo = tempNodo.siguiente;
                contador++;
            }

            tempNodo = cabeza;
            contador = 0;
            //para crear las conexiones entre nodos
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

            comando = comando + "label = \"Ventanillas\";";
            comando = comando + "}";
        } else {
            System.out.println("Lista vacía");
            
            comando = "digraph ejemplo1\n"
                    + "{\n"
                    + "    rankdir =LR\n label = \"Ventanillas\";}";
        }

        return comando;
    }
    
    public String construirComandoGrafo2()
    {
        
        int contador = 0;
        String comando = "digraph ejemplo1\n"
                + "{\n"
                + "    rankdir =LR\n";

        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            //Para crear los nodos
            while (tempNodo != null) {

                comando = comando + "\n" + "Nodo" + contador + "[" + "label=\"V " + tempNodo.ventanilla.getCodigoVentanilla() + ", U:" + tempNodo.ventanilla.getUserName() + "\",color=\"#40e0d0\", shape=box, style=filled, fillcolor=\"#1C0049\" , fontcolor=\"#FF0096\"];";
                tempNodo = tempNodo.siguiente;
                contador++;
            }

            tempNodo = cabeza;
            contador = 0;
            //para crear las conexiones entre nodos
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

            comando = comando + "label = \"Ventanillas\";";
            
                       
            //__________________________________________
            
            tempNodo = cabeza;

            //Para crear los nodos de imagenes, recorre la lista otra vez, ejecutando a su vez un recorrido de cada lista en cada ventanilla
            while (tempNodo != null) {

                if (tempNodo.siguiente == null) {
                    tempNodo = tempNodo.siguiente;
                    contador++;

                } else {
                    comando = comando + tempNodo.ventanilla.ConstruirComandoGrafo(contador);
                    tempNodo = tempNodo.siguiente;
                    contador++;

                }
            }
            
            //__________________________________________
            
            
            comando = comando + "}";
        } else {
            System.out.println("Lista vacía");

            comando = "digraph ejemplo1\n"
                    + "{\n"
                    + "    rankdir =LR\n label = \"Ventanillas(Completo)\";";
            comando = comando + "\n}";
        }

        return comando;
        
    }
}
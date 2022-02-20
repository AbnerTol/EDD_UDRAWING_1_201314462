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
    private ListaClientesAtendidos listaClientesAtendidos;

    private class Nodo {

        public Usuario usuario;
        public Nodo siguiente = null;
        int tamañoLista = 0;

        //Constructor
        public Nodo(Usuario usuario) {
            this.usuario = usuario;
        }
    }

    public ListaClientesEnEspera( ListaClientesAtendidos listaClientesAtendidos )
    {
        this.listaClientesAtendidos = listaClientesAtendidos;
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
    
    //Recorre la lista de clientes, comparando el Id de la imagen que recibió. Cuando encuentra un cliente que hace match con la imagen, le adjunta la imagen
    public void recibirImagenyBuscarlePropietario( Imagen imagen )
    {
        
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;
            int posicion = 1;
            
            while (tempNodo != null) {
                
                //Valida si el id del usuario es el mismo id que trae la imagen recibida
                if( tempNodo.usuario.getUserId() == imagen.getIdImagen() )
                {
                    //Inserta la imagen en el usuario respectivo
                    tempNodo.usuario.getListaImagen().insertarFinal(imagen);
                    
                    //Verifica si ya tiene todas sus imagenes
                    if(  VerificarSiUsuarioTieneTodasSusImagenes(tempNodo.usuario ) )
                    {
                        //Envía el usuario a la lista clientes atendidos 
                        EnviarUsuarioAClientesAtendidos( tempNodo.usuario );
                        //Elimina el usuario actual
                        eliminar( posicion );
                        System.out.println("--------------------------Cliente Atendido------------------------");
                    }
                   ;
                    break;
                }
                
                else
                {
                    
                    tempNodo = tempNodo.siguiente;
                    
                }
            }
        } else {
            System.out.println("Lista vacía");
        }
    }
    
    public boolean VerificarSiUsuarioTieneTodasSusImagenes(  Usuario usuario )
    {
        int totalImagenes = usuario.getBWImages() + usuario.getColorImages();
        int imagenesRecibidas = usuario.getListaImagen().getTamañoLista();

        if (totalImagenes == imagenesRecibidas) {
            
            return true;
            
        } else {
            return false;
        }
    }
    
    public void EnviarUsuarioAClientesAtendidos( Usuario usuario )
    {
        listaClientesAtendidos.insertarFinal( usuario );
    }
    
    // _________________________________________________________________________Eliminar________________________________________________________________________________

//    //Este sirve para eliminar el primer cliente que llegó a cola de recepción, para ser enviado a la lista de clientes atendidos
//    public Usuario eliminarPrimerCliente() {
//
//        Usuario temp = this.cabeza.usuario;
//        //Eliminar el primero
//        this.cabeza = this.cabeza.siguiente;
//        tamañoLista--;
//        return temp;
//    }
    
    public void eliminar(int posicion) {
        if (posicion > tamañoLista) {
            System.out.println("Error, número invalido.");
        } else {
            //Eliminar el primero
            if (posicion == 1) {
                this.cabeza = this.cabeza.siguiente;
                tamañoLista--;
            } //Eliminar el último
            else if (posicion == tamañoLista) {
                Nodo temp = cabeza;
                for (int i = 1; i < tamañoLista - 1; i++) {
                    temp = temp.siguiente;
                }

                temp.siguiente = null;
                tamañoLista--;

            } //Eliminar en medio
            else {
                int n = 1;
                Nodo temp1 = cabeza;
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

                tamañoLista--;

            }
        }

    }
    // _________________________________________________________________________Imprimir Lista________________________________________________________________________________
    public void imprimirLista() {
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Impresión de Lista de Espera: ");
        if (tamañoLista >= 1) {
            Nodo tempNodo = cabeza;

            while (tempNodo != null) {
                System.out.println(tempNodo.usuario.getAllInfo());
                
                tempNodo.usuario.getListaImagen().imprimirLista();
                
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

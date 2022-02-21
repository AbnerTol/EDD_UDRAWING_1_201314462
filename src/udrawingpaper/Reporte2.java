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
    
    public void ValidarUsuarioEntrante( Usuario usuario )
    {
        
    }
    
    public void getTop5()
    {
        imprimirLista();
    }
    
     public void imprimirLista() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Top 5 usuarios con mayor cantidad de imágenes a color");
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
    
}

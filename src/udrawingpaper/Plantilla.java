///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package javaapplication3;
//
//import java.awt.Desktop;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//
///**
// *
// * @author Brown
// */
//public class Lilsta {
//    
//    private Nodo cabeza;
//    private int tamañoLista;
//    
//    private  class Nodo
//    {
//        public Libro libro;
//        public Nodo siguiente = null;
//        int tamañoLista = 0;
//        
//        public Nodo(Libro libro)
//        {
//            this.libro = libro;
//        }
//    }
//    
//    //_____________________________________________Insertar_________________________________________________
//    public void insertarPrincipio(Libro libro)
//    {
//        Nodo nodo = new Nodo(libro);
//        nodo.siguiente = cabeza;
//        cabeza = nodo;
//        
//        
//        tamañoLista ++;
//    }
//    
//    public void insertarFinal(Libro libro)
//    {
//        if( tamañoLista >= 1)
//        {
//            Nodo tempNodo = cabeza;
//            Nodo nodo = new Nodo(libro);
//
//            while (tempNodo.siguiente != null) {
//                tempNodo = tempNodo.siguiente;
//            }
//
//            tempNodo.siguiente = nodo;
//            tamañoLista++;            
//        }
//        else
//        {
//            Nodo nodo = new Nodo(libro);
//            cabeza = nodo;
//            tamañoLista++;
//        }
//    }
//    
//    public void insertarEnMedio(int posicion, Libro libro)
//    {
//        if( tamañoLista < 2 )
//        {
//            System.out.println("Imposible agregar en medio");
//        }
//        
//        else
//        {
//            if (posicion > tamañoLista) {
//                System.out.println("Posición inválida");
//            } 
//            
//            else if (posicion == 1) {
//                System.out.println("Posición inválida");
//            } 
//            
//            else {
//                Nodo tempNodo = cabeza;
//                Nodo tempNodo2;
//
//                Nodo nodo = new Nodo(libro);
//
//                for (int i = 1; i < posicion - 1; i++) {
//                    System.out.println("Iteración: " + i);
//                    tempNodo = tempNodo.siguiente;
//
//                }
//
//                //Copia temporal del nodo en donde se detuvo el for
//                tempNodo2 = tempNodo.siguiente;
//
//                tempNodo.siguiente = nodo;
//
//                nodo.siguiente = tempNodo2;
//
//                tamañoLista++;
//            }
//        }
//        
//        
//    }
//    
//    //_____________________________________________Eliminar_________________________________________________
//    
//    public void eliminar( int posicion )
//    {
//        if( posicion > tamañoLista)
//        {
//            System.out.println("Error, número invalido.");
//        }
//        
//        else
//        {
//            //Eliminar el primero
//            if (posicion == 1) 
//            {
//                this.cabeza = this.cabeza.siguiente;
//                tamañoLista--;
//            } 
//            //Eliminar el último
//            else if (posicion == tamañoLista) 
//            {                
//                Nodo temp = cabeza;
//                for( int i=1; i<tamañoLista-1; i++)
//                {
//                    temp = temp.siguiente;               
//                }
//                
//                temp.siguiente = null;
//                tamañoLista--;
//                
//            } 
//            //Eliminar en medio
//            else 
//            {
//                int n=1;
//                Nodo temp1 = cabeza;
//                Nodo temp2 = null;
//                
//                while( temp1 != null )
//                {
//                    if( n< posicion )
//                    {
//                        temp2 = temp1;
//                        temp1 = temp1.siguiente;
//                       
//                        System.out.println(n);
//                    }
//                    else
//                    {
//                        temp2.siguiente = temp1.siguiente;
//                        System.out.println("Llegó al número solicitado, procediendo ...");
//                        break;
//                    }
//                    
//                     n++;
//                }
//                
//                tamañoLista--;
//
//               
//            }
//        }
//
//    }
//    
//    public void eliminarPorNombre( String nombre )
//    {
//        Nodo temp1 = cabeza;
//        Nodo temp2 = null;
//        
//        int posicion = 0;
//
//        //itera mientras el nodo actual no sea null
//        while (temp1 != null) 
//        {
//            System.out.print("Nombre: " + nombre);
//            System.out.println("Libro guardado: " + temp1.libro.getBook().toString());
//            //Evalúa si la palabra es igual al libro actual
//            if ( nombre.equals( temp1.libro.getBook().toString() ) ) 
//            {
//                //Toma la posición de temp2 (el nodo 'anterior') y la enlaza a la posición siguiente de temp1 (Ignorando así el nodo de en medio: temp1)
//                
//                temp2.siguiente = temp1.siguiente;
//                System.out.println("Libro encontrado y elminado ...");
//                this.tamañoLista--;
//                break;
//                
//            } else 
//            {              
//                temp2 = temp1;
//                temp1 = temp1.siguiente;
//
//                System.out.println(posicion);
//            }
//
//            posicion++;
//            
//            if( temp1 == null)
//            {
//                System.out.println("No se ha encontrado el libro solicitado, intente nuevamente");
//            }
//        }
//        
//    }
//    public void eliminarTodo()
//    {
//        cabeza = null;
//        tamañoLista = 0;
//    }
//    
//    //______________________________________________________________________________________________________
//    public void imprimirLista()
//    {
//        if(tamañoLista >=1)
//        {
//            Nodo tempNodo = cabeza;
//
//            System.out.print("\n\n\n\n\n");
//            while (tempNodo != null) {
//                System.out.println(tempNodo.libro.getInfo());
//                tempNodo = tempNodo.siguiente;
//            }            
//        }
//        else
//        {
//            System.out.println("Lista vacía");
//        }
//         
//    }
//    
//    public int obtenerTamañoLista()
//    {
//        return tamañoLista;
//    }
//    
//    //_____________________________________________Grafo_________________________________________________
//    
//        public void construirGrafo()
//        {
//            String comandoGraphviz="digraph ejemplo1\n{\n";
//            
//            if (tamañoLista >= 1) {
//                Nodo tempNodo = cabeza;
//                
//                //Creación de nodos y etiquetas
//                for(int i=0; i<tamañoLista; i++)
//                {
//                    String nombreLibro = tempNodo.libro.getBook();
//                    comandoGraphviz = comandoGraphviz + "Nodo" + i + "[label=\"" + nombreLibro + "\"];\n";
//                    tempNodo = tempNodo.siguiente;
//                }
//                
//                //Creación de enlaces        
//                comandoGraphviz = comandoGraphviz + "\n";
//                tempNodo = cabeza;
//                
//                for(int i=0; i<tamañoLista-1; i++)
//                {
//                    comandoGraphviz = comandoGraphviz + "Nodo" + i + "->Nodo" + (i+1) + ";\n";
//                    tempNodo = tempNodo.siguiente;
//                }
//                
//                comandoGraphviz = comandoGraphviz + "}";
//                System.out.println(comandoGraphviz);
//            } else {
//                System.out.println("Lista vacía");
//            }
//
//            escribirGrafo(comandoGraphviz);
//            RunBat();
//            OpenImage();
//            
//        }
//        
//        public void escribirGrafo(String codigo)
//        {
//
//            try {
//                //File myObj = new File("D:\\Users\\Brown\\Documents\\Graphviz\\filename.dot");
//                FileWriter myWriter = new FileWriter("D:\\Users\\Brown\\Documents\\Graphviz\\ejemplo1.dot");
//                myWriter.write("" + codigo);
//                myWriter.close();
//
//            } catch (IOException e) {
//                System.out.println("An error occurred.");
//                e.printStackTrace();
//            }
//        }
//        
//        public void RunBat()
//        {
//            try {
//                Process p = Runtime.getRuntime().exec("\"D:\\Users\\Brown\\Documents\\Graphviz\\test2.bat\"");
//            } catch (Exception e) {
//
//            }
//            
//
//        }
//        
//        public void OpenImage()
//        {
//            try {
//                System.out.println("------------");
//                File f = new File("D:\\Users\\Brown\\Documents\\Graphviz\\imagen.png");
//                Desktop dt = Desktop.getDesktop();
//                dt.open(f);
//                System.out.println("Done.");
//                
//                System.out.println("------------");
//                
//            } catch (Exception e) {
//                System.out.println("Error");
//            }
//            
//            
//            
//        }
//    //___________________________________________________________________________________________________
//    
//}
//

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author Brown
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private int color;
    private int byn;
    private ListaImagen listaImagen;
    private int pasosRequeridos;
    private int ventanillaQueAtendio;
    
    public Usuario(int id, String nombre, int color, int byn) 
    {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.byn = byn;
        
        this.listaImagen = new ListaImagen(null, null);
        pasosRequeridos = 1;
    }

    public String getAllInfo() {
        String info = "Id: " + id + " Nombre: " + nombre + " Color: " + color + " Byn: " + byn;
        return info;
    }

    public void setVentanillaQueAtendio( int codigoVentanilla )
    {
        this.ventanillaQueAtendio = codigoVentanilla;
    }
    
    public int getVentanillaQueAtendio()
    {
        return this.ventanillaQueAtendio;
    }
    
    public int getColorImages()
    {
        return this.color;
    }
    public int getBWImages() 
    {
        return this.byn;
    }
    
    public int getUserId()
    {
        return id;
    }
    
    public String getUserName()
    {
        return this.nombre;
    }
    
    //Solo se ocupará mientras esté en Lista de clientes en espera
    public ListaImagen getListaImagen()
    {
        return this.listaImagen;
    }
    
    public void ActualizarVariablepasosRequeridos()
    {
        this.pasosRequeridos++;
    }
    
    public int getPasosRequeridos()
    {
        return this.pasosRequeridos;
    }
    
    
}

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

    
    public Usuario(int id, String nombre, int color, int byn) 
    {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.byn = byn;
    }

    public String getAllInfo() {
        String info = "Id: " + id + " Nombre: " + nombre + "Color: " + color + "Byn: " + byn;
        return info;
    }

    public int getColorImages()
    {
        return this.color;
    }
    
    public int getBWImages() 
    {
        return this.byn;
    }
    
    public String getUserName()
    {
        return this.nombre;
    }
}

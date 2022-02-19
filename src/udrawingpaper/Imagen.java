/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author Brown
 */
public class Imagen {
    
    private String RutaImagen;
    private String TipoImagen;
    private int IdUsuario;

    Imagen( int IdUsuario, String RutaImagen, String TipoImagen ) {
        this.IdUsuario = IdUsuario;
        this.RutaImagen = RutaImagen;
        this.TipoImagen = TipoImagen;
    }

    public String getAllInfo() {
        String info = "Id: " + IdUsuario + "Ruta: " + RutaImagen + " Tipo : " + TipoImagen;
        return info;
    }
    
    public String getTipoImagen()
    {
        return this.TipoImagen;
    }
    
}

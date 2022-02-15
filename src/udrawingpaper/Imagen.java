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
    
    String RutaImagen;
    String TipoImagen;

    Imagen(String RutaImagen, String TipoImagen) {
        this.RutaImagen = RutaImagen;
        this.TipoImagen = TipoImagen;
    }

    public String getAllInfo() {
        String info = "Ruta: " + RutaImagen + " Tipo : " + TipoImagen;
        return info;
    }

    
}

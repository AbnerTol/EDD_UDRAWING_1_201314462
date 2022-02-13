/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author Brown
 */
public class ColaImagenVentanilla {
    
    String RutaImagen;
    String TipoImagen;
            
    ColaImagenVentanilla( String RutaImagen, String TipoImagen )
    {
        this.RutaImagen = RutaImagen;
        this.TipoImagen = TipoImagen;
    }
    
    public String getAllInfo() {
        String info = "Ruta: " + RutaImagen + " Tipo : "  + TipoImagen;
        return info;
    }

}

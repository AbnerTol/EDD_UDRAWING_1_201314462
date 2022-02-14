/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

/**
 *
 * @author Brown
 */
public class Ventanilla {
        
    private int codigoVentanilla;
    private Usuario usuarioActivo;
    
    public Ventanilla( int codigoVentanilla, Usuario usuarioActivo )
    {
        this.codigoVentanilla = codigoVentanilla;
        this.usuarioActivo = usuarioActivo;
    }
    
    public String getAllInfo()
    {
        
        if( usuarioActivo == null )
        {
            return "Código ventanillia: " + this.codigoVentanilla + " Usuario : VACÍO" ;
        }
        else
        {
            return "Código ventanillia: " + this.codigoVentanilla + " Usuario[" + usuarioActivo.getAllInfo() +"]";
        }
        
       
    }
    
    public Usuario verificarUsuario()
    {
        return this.usuarioActivo;
    }
    
    public void recibirUsuario( Usuario usuarioActivo )
    {
        this.usuarioActivo = usuarioActivo;
        System.out.println("Usuario recibido correctamente a Ventanilla: " + codigoVentanilla);
    }
   
    
    
}

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
        return "Código " + this.codigoVentanilla;
    }
    
    public Usuario verificarUsuario()
    {
        return this.usuarioActivo;
    }

    
    
}

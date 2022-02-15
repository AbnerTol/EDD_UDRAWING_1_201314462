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
    private int color;
    private int bw;
    
    private ListaImagen listaImagen;
    
    public Ventanilla( int codigoVentanilla, Usuario usuarioActivo )
    {
        this.codigoVentanilla = codigoVentanilla;
        this.usuarioActivo = usuarioActivo;
        
        listaImagen = new ListaImagen();
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
        setTypes();
        System.out.println("Usuario recibido correctamente a Ventanilla: " + codigoVentanilla);
        

    }
      
    public void setTypes()
    {
        this.color = usuarioActivo.getColorImages();
        this.bw = usuarioActivo.getBWImages();
        System.out.println("setTypes() ejecutado correctamente: " + color + " " + bw);
        
    }
    
    
    public void AgregarImagen()
    {
      
        if( this.color >0 )
        {
            this.color--;
            Imagen imagen = new Imagen(usuarioActivo.getUserName(), "Color");
            listaImagen.insertarPrincipio(imagen);
            
        }else if( this.bw>0 )
        {
            this.bw--;
            Imagen imagen = new Imagen(usuarioActivo.getUserName(), "BW");
            listaImagen.insertarPrincipio(imagen);
        }
        
        else
        {
            //hace falta crear un método que 'saque' el usuario actual y lo envíe a donde pertenece.
            System.out.println("Este usuario no tiene más imágenes por agregar");
        }
    
            
        
    }
    
    
}

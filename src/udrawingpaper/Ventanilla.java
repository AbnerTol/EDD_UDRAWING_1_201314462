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
    private ListaClientesEnEspera listaClientesEnEspera;
    
    
    public Ventanilla( int codigoVentanilla, Usuario usuarioActivo, ListaClientesEnEspera listaClientesEnEspera )
    {
        this.codigoVentanilla = codigoVentanilla;
        this.usuarioActivo = usuarioActivo;
        
        listaImagen = new ListaImagen();
        
        this.listaClientesEnEspera = listaClientesEnEspera;
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
    
    public int getCodigoVentanilla()
    {
        return this.codigoVentanilla;
    }
    
    public String getUserName()
    {
        return this.usuarioActivo.getUserName();
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

        
    }
    
    
    public void AgregarImagen()
    {
        if( this.usuarioActivo != null )
        {
            //Valida si aún existen imágenes a color
            if (this.color > 0) {
                this.color--;
                Imagen imagen = new Imagen(usuarioActivo.getUserName(), "Color");
                listaImagen.insertarFinal(imagen);

            } //En caso que no hayan imágnes a color entonces valida las imágenes blanco y negro
            else if (this.bw > 0) {
                this.bw--;
                Imagen imagen = new Imagen(usuarioActivo.getUserName(), "BW");
                listaImagen.insertarFinal(imagen);
            } //En caso que no existan más imágenes, toma la referencia del usuario y la envía hacia ListaClientesEnEspera y elimina la referencia de esta ventanilla, quedando así disponible.
            else {
                VaciarVentanilla();
                System.out.println("Ventanilla " + this.codigoVentanilla + " liberada");

            }
            
        }     
                 
    }
    
    //Elimina el usuario de la ventanilla y lo envía a clientes en espera
    public void VaciarVentanilla()
    {
        listaClientesEnEspera.insertarFinal(usuarioActivo);
        usuarioActivo = null;
        listaImagen = new ListaImagen();
        
    }
    
    public void ImprimirListaImagenes()
    {
        listaImagen.imprimirLista();
    }
    
}

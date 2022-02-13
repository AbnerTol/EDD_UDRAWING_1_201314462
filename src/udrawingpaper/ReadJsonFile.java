/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udrawingpaper;

import java.util.ArrayList;

/**
 *
 * @author Brown
 */
public class ReadJsonFile {
    
    // Llenaremos temporalmente un arraylist en lo que se resuelve el problema con la librería y el formato
    
    ArrayList<String[]> user;
    
    public void CreateUsers()
    {
        //Creación de usuarios
        String temp1[];
        String temp2[];
        String temp3[];
        String temp4[];
        String temp5[];
        String temp6[];
        String temp7[];
        String temp8[];
        String temp9[];
        String temp10[];
        
        temp1= new String[4];
        temp1[0] = "1"; //id
        temp1[1] = "Nombre1 Apellido1"; //nombre
        temp1[2] = "3"; //img color
        temp1[3] = "1"; //img byn
        
        temp2 = new String[4];
        temp2[0] = "2"; //id
        temp2[1] = "Nombre2 Apellido2"; //nombre
        temp2[2] = "1"; //img color
        temp2[3] = "1"; //img byn
        
        temp3 = new String[4];
        temp3[0] = "3"; //id
        temp3[1] = "Nombre3 Apellido3"; //nombre
        temp3[2] = "1"; //img color
        temp3[3] = "1"; //img byn
        
        temp4 = new String[4];
        temp4[0] = "4"; //id
        temp4[1] = "Nombre4 Apellido4"; //nombre
        temp4[2] = "4"; //img color
        temp4[3] = "0"; //img byn
        
        temp5 = new String[4];
        temp5[0] = "5"; //id
        temp5[1] = "Nombre5 Apellido5"; //nombre
        temp5[2] = "0"; //img color
        temp5[3] = "2"; //img byn
       
        temp6 = new String[4];
        temp6[0] = "6"; //id
        temp6[1] = "Nombre6 Apellido6"; //nombre
        temp6[2] = "1"; //img color
        temp6[3] = "2"; //img byn
        
        temp7 = new String[4];
        temp7[0] = "7"; //id
        temp7[1] = "Nombre7 Apellido7"; //nombre
        temp7[2] = "2"; //img color
        temp7[3] = "1"; //img byn
        
        temp8 = new String[4];
        temp8[0] = "8"; //id
        temp8[1] = "Nombre8 Apellido8"; //nombre
        temp8[2] = "3"; //img color
        temp8[3] = "3"; //img byn
        
        temp9 = new String[4];
        temp9[0] = "9"; //id
        temp9[1] = "Nombre9 Apellido9"; //nombre
        temp9[2] = "4"; //img color
        temp9[3] = "2"; //img byn
        
        temp10 = new String[4];
        temp10[0] = "10"; //id
        temp10[1] = "Nombre10 Apellido10"; //nombre
        temp10[2] = "5"; //img color
        temp10[3] = "1"; //img byn
        
              
        user = new ArrayList<String[]>();
        user.add(temp1);
        user.add(temp2);
        user.add(temp3);
        user.add(temp4);
        user.add(temp5);
        user.add(temp6);
        user.add(temp7);
        user.add(temp8);
        user.add(temp9);
        user.add(temp10);
        
        System.out.println("Usuarios creados exitosamente");
    }
    
    public String[] GetUser( int code )
    {
       return user.get(code);
    }
    
    public int GetSize()
    {
        return user.size();
    }
    
}

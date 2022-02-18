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
        String temp0[];
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
        String temp11[];
        String temp12[];
        String temp13[];
        String temp14[];
        String temp15[];
        String temp16[];
        String temp17[];
        String temp18[];
        String temp19[];
        String temp20[];
        
        temp0 = new String[4];
        temp0[0] = "1"; //id
        temp0[1] = "Camilo Sesto"; //nombre
        temp0[2] = "3"; //img color
        temp0[3] = "1"; //img byn
        
        temp1= new String[4];
        temp1[0] = "1"; //id
        temp1[1] = "Juan Ratón"; //nombre
        temp1[2] = "3"; //img color
        temp1[3] = "1"; //img byn
        
        temp2 = new String[4];
        temp2[0] = "2"; //id
        temp2[1] = "Amilcar Talegazo"; //nombre
        temp2[2] = "1"; //img color
        temp2[3] = "1"; //img byn
        
        temp3 = new String[4];
        temp3[0] = "3"; //id
        temp3[1] = "Brandon Pelicano"; //nombre
        temp3[2] = "1"; //img color
        temp3[3] = "1"; //img byn
        
        temp4 = new String[4];
        temp4[0] = "4"; //id
        temp4[1] = "Maria Trompuda"; //nombre
        temp4[2] = "4"; //img color
        temp4[3] = "1"; //img byn
        
        temp5 = new String[4];
        temp5[0] = "5"; //id
        temp5[1] = "Jimena Sal"; //nombre
        temp5[2] = "1"; //img color
        temp5[3] = "2"; //img byn
       
        temp6 = new String[4];
        temp6[0] = "6"; //id
        temp6[1] = "Erick Cabra"; //nombre
        temp6[2] = "1"; //img color
        temp6[3] = "2"; //img byn
        
        temp7 = new String[4];
        temp7[0] = "7"; //id
        temp7[1] = "Shuho Diana"; //nombre
        temp7[2] = "2"; //img color
        temp7[3] = "1"; //img byn
        
        temp8 = new String[4];
        temp8[0] = "8"; //id
        temp8[1] = "Helena Queso"; //nombre
        temp8[2] = "3"; //img color
        temp8[3] = "3"; //img byn
        
        temp9 = new String[4];
        temp9[0] = "9"; //id
        temp9[1] = "Rodrigo Pan"; //nombre
        temp9[2] = "4"; //img color
        temp9[3] = "2"; //img byn
        
        temp10 = new String[4];
        temp10[0] = "10"; //id
        temp10[1] = "Alejandra Tortrix"; //nombre
        temp10[2] = "5"; //img color
        temp10[3] = "1"; //img byn
        
        temp11 = new String[4];
        temp11[0] = "11"; //id
        temp11[1] = "Stella Cox"; //nombre
        temp11[2] = "5"; //img color
        temp11[3] = "1"; //img byn
        
        temp12 = new String[4];
        temp12[0] = "12"; //id
        temp12[1] = "Alexander Corsair"; //nombre
        temp12[2] = "5"; //img color
        temp12[3] = "1"; //img byn
        
        temp13 = new String[4];
        temp13[0] = "13"; //id
        temp13[1] = "Alison Yamaha"; //nombre
        temp13[2] = "5"; //img color
        temp13[3] = "1"; //img byn
        
        temp14 = new String[4];
        temp14[0] = "14"; //id
        temp14[1] = "Daryan Migitorio"; //nombre
        temp14[2] = "5"; //img color
        temp14[3] = "1"; //img byn
        
        temp15 = new String[4];
        temp15[0] = "15"; //id
        temp15[1] = "Juanito Nutria"; //nombre
        temp15[2] = "5"; //img color
        temp15[3] = "1"; //img byn
        
        temp16 = new String[4];
        temp16[0] = "16"; //id
        temp16[1] = "Miranda Lapiz"; //nombre
        temp16[2] = "5"; //img color
        temp16[3] = "1"; //img byn
        
        temp17 = new String[4];
        temp17[0] = "17"; //id
        temp17[1] = "Vicente Charro"; //nombre
        temp17[2] = "5"; //img color
        temp17[3] = "1"; //img byn
        
        temp18 = new String[4];
        temp18[0] = "18"; //id
        temp18[1] = "Antonio Vivalidi"; //nombre
        temp18[2] = "5"; //img color
        temp18[3] = "1"; //img byn
        
        temp19 = new String[4];
        temp19[0] = "19"; //id
        temp19[1] = "Teresa Disco"; //nombre
        temp19[2] = "5"; //img color
        temp19[3] = "1"; //img byn
        
        temp20 = new String[4];
        temp20[0] = "20"; //id
        temp20[1] = "Ana Tax"; //nombre
        temp20[2] = "5"; //img color
        temp20[3] = "1"; //img byn
        
        user = new ArrayList<String[]>();
        user.add(temp0);
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
        user.add(temp11);
        user.add(temp12);
        user.add(temp13);
        user.add(temp14);
        user.add(temp15);
        user.add(temp16);
        user.add(temp17);
        user.add(temp18);
        user.add(temp19);
        user.add(temp20);
        
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

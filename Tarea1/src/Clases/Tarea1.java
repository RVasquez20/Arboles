/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Vista.Main;
import static Vista.Main.Image;


/**
 *
 * @author Rodrigo
 */
public class Tarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
         Main V=new Main();
        Tabla T = new Tabla();
        T.Graficar();
        
        Thread.sleep(2000);
        String TF="";
        TF=T.getC();
        
        V.RepList.setText(TF);
        Image.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\GitHub\\Arboles\\Tarea1\\ArbolGenerado.jpg"));
        V.show();
        
        
    
          
    }
    
}

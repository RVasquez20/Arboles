/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tabla {

private String C;
    public Tabla() {
    }
public void Graficar(){
  Arbol arbol2=new Arbol();
       String Cadena="";
        Cadena= JOptionPane.showInputDialog(null,"Ingrese la Representacion de Lista del Arbol:","Ingreso",JOptionPane.QUESTION_MESSAGE);
        setC(Cadena);
        HashMap<String, String> Tabla = new HashMap<String, String>();

        LinkedList<String> cola =new LinkedList<String>();
        Stack<String> pila =new Stack<String>();
        String[] parts = Cadena.split(",");
        String CadenaCompuesta="";
        for (String x:
                parts) {
            CadenaCompuesta+=x;
        }
        String[] parte = CadenaCompuesta.split(" ");
        CadenaCompuesta="";
        for (String x:
                parte) {
            CadenaCompuesta+=x;
        }

        int longitud=0;
        longitud=CadenaCompuesta.length()-1;
        for (int  i=0; i<=longitud ; i++) {
            cola.add(String.valueOf(CadenaCompuesta.charAt(i)));

        }
        String raiz=cola.remove();
        Tabla.put(raiz,"0");
        String aux="",aux2="",aux3="",Padre="",Hijo="",Punto="";
        pila.push(raiz);
        Punto=cola.removeLast();
        if(!Punto.equals(".")){
            cola.addLast(Punto);
        }
        while(!cola.isEmpty()){
            aux=cola.remove();
            if(aux.equals("(")){
                Hijo=cola.remove();
                Padre=pila.pop();
                Tabla.put(Hijo,Padre);
                aux2=cola.remove();
                if(aux2.equals("(")){
                    pila.push(Padre);
                    pila.push(Hijo);
                    cola.addFirst(aux2);
                }
                if(!aux2.equals("(")&&!aux2.equals(")")){
                    pila.push(Padre);
                    cola.addFirst(aux2);
                }
            }
else if(aux.equals(")")){
    if(!pila.isEmpty()){
                    pila.pop();
                }
            }
            else {
                aux2=cola.remove();
                Padre=pila.pop();
                if(aux2.equals(")")){
                    Tabla.put(aux,Padre);
                }
                if(aux2.equals("(")){
                    Tabla.put(aux,Padre);
                    pila.push(Padre);
                    pila.push(aux);
                }
                if(!aux2.equals("(")&&!aux2.equals(")")){
                    aux3=cola.remove();
                    if(aux3.equals(")")){
                        Tabla.put(aux,Padre);
                        Tabla.put(aux2,Padre);
                    }
                    else if(aux3.equals("(")){
                        Tabla.put(aux,Padre);
                        Tabla.put(aux2,Padre);
                        pila.push(Padre);
                        pila.push(aux2);
                        cola.addFirst(aux3);
                    }
                    else{
                        Tabla.put(aux,Padre);
                        cola.addFirst(aux3);
                        cola.addFirst(aux2);
                        pila.push(Padre);
                    }
                }
            }

        }
        
        for (String x : Tabla.keySet()) {
            arbol2.insertarNodo(x, Tabla.get(x));      
        }

        arbol2.graficarArbol(arbol2); 
}

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    
    

   
    
    
}

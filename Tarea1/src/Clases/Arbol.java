/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
class Nodo {
    
    String valor;    
    ArrayList<Nodo> hijos;

    Nodo(String newData) {
      hijos = new ArrayList<>();
      valor = newData;
    } 
  } 
public class Arbol {
       private Nodo raiz; 
    GraphViz graficador = new GraphViz();      
        
  public Arbol() {
    raiz = null; 
    graficador.addln(graficador.start_graph());
  } 
    
  public Nodo buscarRecursivo(String data) { 
    return(buscarRecursivo(raiz, data)); 
  }     
  
 
  Nodo resultado = null;
  private Nodo buscarRecursivo(Nodo node, String valorBuscado) { 
    if (node==null) 
      resultado = null;      

    if (valorBuscado == node.valor)        
      resultado = node; 
          
    for(Nodo tmp: node.hijos)    
      buscarRecursivo(tmp, valorBuscado); 
    
    return resultado;
  }      
    
  public void insertarNodo(String valor, String padre)
  {      
      raiz = insertarNodo(raiz, valor, padre);
  }
    
  private Nodo insertarNodo(Nodo nodo, String valor, String padre)
  {              
      if(nodo == null)
          nodo = new Nodo(valor);                                                                                             
      else 
      {          
          Nodo nodoPadre = buscarRecursivo(padre);
          if(nodoPadre != null)          
              nodoPadre.hijos.add(new Nodo(valor));
          else
              nodo.hijos.add(new Nodo(valor));
      }
      return nodo;
  }
  

  public String buscarNodo(String valorNodo)
  {      
      String x;
      int y;
      y=nodosVisitados.indexOf(valorNodo);
      x=String.valueOf(y);
      return x;
      
  }
  
  public void finalizarGrafica()
  {
      
      graficador.addln(graficador.end_graph());
        
          
          String type = "jpg";
          File out = new File("ArbolGenerado." + type);
          graficador.writeGraphToFile(graficador.getGraph(graficador.getDotSource(), type), out);
  }
  
  static int contadorNodos = 0;
  static int contadorNulos = 0;
  static ArrayList<String> nodosVisitados = new ArrayList<>();
  private void encontrarNodos(Nodo nodo, Arbol arbol)
  {
      if(nodo != null)
      {
          
          String nulo = "null";
          
          graficador.addln(String.format(
                  "%s [ label=<%s> ]", contadorNodos, nodo.valor));                         
          nodosVisitados.add(nodo.valor);  
        
          contadorNodos++;
          
          for(Nodo tmp: nodo.hijos)
          {
            if(tmp == null)
            {
                nulo = "null" + contadorNulos;
                contadorNulos++;
                graficador.addln(String.format("%s[shape=point]", nulo));                                       
            }                        
            encontrarNodos(tmp, arbol);                                            
          }
      }
  }      
  static int nuevoContadorNulos = 0;
  public void asignarPadreHijo(Nodo nodo, Arbol arbol)
  {
      if(nodo != null)
      {         
          for(Nodo tmp: nodo.hijos)
          {
              if(tmp != null)
                  graficador.addln(String.format(
                      "%s -> %s", buscarNodo(nodo.valor), buscarNodo(tmp.valor)));   
              else
                  graficador.addln(String.format(
                      "%s -> %s", buscarNodo(nodo.valor), "null" + nuevoContadorNulos++));                                                                
              asignarPadreHijo(tmp, arbol);             
          }
      }
  }
  
  public void graficarArbol(Arbol arbol)
  {            
      graficador.addln("ordering = out");  
      encontrarNodos(raiz, arbol);                 
      asignarPadreHijo(raiz, arbol);
      finalizarGrafica();
  }

  static int tamaño = 0;
  public int obtenerTamaño(Nodo nodo, Arbol arbol)
  {
      if(nodo != null)
      {
          tamaño++;
          for(Nodo tmp: nodo.hijos)
            obtenerTamaño(tmp, arbol);                    
      }
      return tamaño;
  }
}

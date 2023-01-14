/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;
import controlador.listas.ListaEnlazada;
import controlador.grafo.Adyacencia;
/**
 *
 * @author Dennys
 */
public abstract class Grafo{
    //nodo
    //arista conexion de un nodo A a un nodo B
    
   /**
    * 
    * Numero de vertices del verbo 
    */
    public abstract Integer numeroDeVertices();
    public abstract Integer numeroDeAristas();
    //public abstract Integer matrizLista();
    public abstract Boolean existeArista(Integer O,Integer D) throws Exception;
    public abstract Double pesoArista(Integer O,Integer D);
    public abstract void insertarArista(Integer O,Integer D) throws Exception;
    public abstract void insertarArista(Integer O,Integer D,Double peso)throws Exception;
    
    
    public abstract ListaEnlazada listaDeAdyacencias(Integer v);
    
    
    @Override
    public String toString(){
        StringBuffer grafo=new StringBuffer("");
        for (int i = 0; i < numeroDeVertices(); i++) {
            grafo.append("Vertice"+String.valueOf(i));
            ListaEnlazada<Adyacencia> lista=listaDeAdyacencias(i);
            for (int j = 0; j < lista.getTamanio(); j++) {
                try {
                    Adyacencia a=lista.obtener(j);
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append(" --- Vertice Destino ---" + a.getDestino() + "--- SP ---");
                    }else{
                        grafo.append("--Vertice Destino"+a.getDestino()+"-- Peso"+a.getPeso());
                    }
                    grafo.append("\n");
                } catch (Exception e) {
                    grafo.append(e.getMessage());
                }
                
            }
    
        }
        return grafo.toString();
    }
    
}

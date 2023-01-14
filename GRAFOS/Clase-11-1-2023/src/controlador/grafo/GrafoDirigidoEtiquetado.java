/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import java.lang.reflect.Array;
import java.util.HashMap;
import controlador.grafo.Adyacencia;
import controlador.listas.ListaEnlazada;

/**
 *
 * @author user-dennys
 */
public class GrafoDirigidoEtiquetado<E> extends GrafoDirigido{
    protected E etiquedas[];
    protected HashMap<E,Integer> dicVertices;
    private Class<E> clazz;
    
    public GrafoDirigidoEtiquetado(Integer numVertices,Class clazz) {
        super(numVertices);
        this.clazz=clazz;
        etiquedas=(E[]) Array.newInstance(clazz,numVertices+1);
        dicVertices=new HashMap<>(numVertices);
    }
    
    public Boolean existeAristaEtiquetada(E o,E d) throws Exception{
        return this.existeArista(obtenerCodigoE(o),obtenerCodigoE(d));
    }
    
    public void insertarAristaEtiquetada(E o,E d,Double peso)throws Exception{
        insertarArista(obtenerCodigoE(o),obtenerCodigoE(d),peso);
    }
    
    public void insertarAristaEtiquetada(E o,E d)throws Exception{
        insertarArista(obtenerCodigoE(o),obtenerCodigoE(d));
    }
    
    public ListaEnlazada<Adyacencia> adyacentesE (E o){
        return listaDeAdyacencias(obtenerCodigoE(o));
    }
    
    private Integer obtenerCodigoE(E etiqueta){
        return dicVertices.get(etiqueta);
    }            
    
    public E obtenerEtiqueta(Integer codigo){
        return etiquedas[codigo];
    }
    
    public void etiquetarVertice(Integer codigo,E etiqueta){
        etiquedas[codigo]=etiqueta;
        dicVertices.put(etiqueta, codigo);
    }


@Override
    public String toString(){
        
        //TODO FALTAN METODO CON GRAFOS DIRIGIDO NO ETIQUETADOS, GRAFICAR BIEN LOS GRAFOS, TOSTRING Y SHA
        StringBuffer grafo=new StringBuffer("");
        for (int i = 0; i < numeroDeVertices(); i++) {
            grafo.append("Vertice"+String.valueOf(i));
            ListaEnlazada<Adyacencia> lista=listaDeAdyacencias(i);
            for (int j = 0; j < lista.getTamanio(); j++) {
                try {
                    Adyacencia a=lista.obtener(j);
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("-- VerticeDestino"+obtenerEtiqueta(Integer.valueOf(a.toString())));
                    }else{
                        //System.out.println(a.getDestino().toString());
                        grafo.append("--"+obtenerEtiqueta(Integer.valueOf(a.getDestino().toString()))+"--Peso"+a.getPeso());
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

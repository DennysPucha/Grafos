/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import controlador.grafo.Exceptions.VerticeOfSizeException;
import controlador.listas.ListaEnlazada;

/**
 *
 * @author Dennys
 */
public class GrafoDirigido extends Grafo{
    private Integer numVertices;
    private Integer numAristas;
    private ListaEnlazada<Adyacencia> listaAdyacente[];

    public GrafoDirigido(Integer numVertices) {
        this.numVertices = numVertices;
        numAristas=0;
        listaAdyacente=new ListaEnlazada[numVertices+1];
        for (int i = 0; i <= this.numVertices; i++) {
            listaAdyacente[i] =new ListaEnlazada<>();
        }
    }

    @Override
    public Integer numeroDeVertices() {
        return numVertices;
    }



    @Override
    public Boolean existeArista(Integer O, Integer D)throws Exception{
        Boolean existe=false;
        if (O.intValue()<=D.intValue() && D.intValue()<=numVertices) {
            ListaEnlazada<Adyacencia> lista=listaAdyacente[O];
            for (int i = 0; i < lista.getTamanio(); i++) {
                Adyacencia a=lista.obtener(i);
                if (a.getDestino().intValue()==D.intValue()) {
                    existe=true;
                    break;
                }
            }
        }else{
            //TODO EXCEPTION VerticeOfSize
            throw new VerticeOfSizeException();
        }
        return existe;
    }

    public void setNumVertices(Integer numVertices) {
        this.numVertices = numVertices;
    }

    public void setNumAristas(Integer numAristas) {
        this.numAristas = numAristas;
    }

    public void setListaAdyacente(ListaEnlazada<Adyacencia>[] listaAdyacente) {
        this.listaAdyacente = listaAdyacente;
    }

    public Integer getNumVertices() {
        return numVertices;
    }

    public Integer getNumAristas() {
        return numAristas;
    }

    public ListaEnlazada<Adyacencia>[] getListaAdyacente() {
        return listaAdyacente;
    }

    
    
    @Override
    public Double pesoArista(Integer O, Integer D) {
        Double peso=Double.NaN;
        try {
            if (existeArista(O, D)) {
                ListaEnlazada<Adyacencia> adyacentes=listaAdyacente[0];
                for (int i = 0; i < adyacentes.getTamanio(); i++) {
                    Adyacencia a=adyacentes.obtener(i);
                    if (a.getDestino().intValue()==D.intValue()) {
                        peso=a.getPeso();
                        break;
                    }
                }
            }else{
                throw new VerticeOfSizeException();
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        return peso;
    }

    @Override
    public void insertarArista(Integer O, Integer D,Double peso) {
        try {
            if (!existeArista(O, D)) {
                numAristas++;
                listaAdyacente[0].insertar(new Adyacencia(D, peso));
            }else{
                throw new VerticeOfSizeException();
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }

    @Override
    public void insertarArista(Integer O, Integer D) {
        insertarArista(O, D, Double.NaN);
    }

    @Override
    public ListaEnlazada listaDeAdyacencias(Integer v) {
        return listaAdyacente[v];
    }

    @Override
    public Integer numeroDeAristas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

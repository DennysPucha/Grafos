package controlador.listas.pilas;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import controlador.listas.pilas.Exceptions.PilaLlenaException;
import controlador.listas.pilas.Exceptions.PilaVaciaException;

public class Pila<E> extends ListaEnlazada<E>{
    private Integer tope;

    public Pila(Integer tope) {
        this.tope = tope;
    }
    
    public Boolean estaLlena(){
        return tope == getTamanio(); 
    }
    
    public void push(E dato) throws PilaLlenaException{
        if(!estaLlena()){
            insertarCabecera(dato);
        }else{
            throw new PilaLlenaException();
        }
    }
    
    public E pop () throws PilaVaciaException, ListaVaciaException, PosicionNoEncontradaException{
        if(!estaVacia()){
            E dato = eliminarPosicion(0);
            
            return dato;
        }else{
            throw new PilaVaciaException();
        }
    }
    
}

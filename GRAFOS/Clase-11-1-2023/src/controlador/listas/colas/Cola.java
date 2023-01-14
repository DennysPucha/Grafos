package controlador.listas.colas;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import controlador.listas.colas.Exceptions.ColaLlenaException;
import controlador.listas.colas.Exceptions.ColaVaciaException;

public class Cola<E> extends ListaEnlazada<E>{
    private Integer cima;

    public Cola(Integer cima) {
        this.cima = cima;
    }
    
    public Boolean estaLlena(){
        return cima == getTamanio(); 
    }
    
    public void queue(E dato) throws ColaLlenaException, PosicionNoEncontradaException{
        if (!estaLlena()) {
            //insertarPosicion(dato, getTamanio());
            insertar(dato);
        }else{
            throw new ColaLlenaException();
        }
    }
    
    public E dequeue() throws ColaVaciaException, ListaVaciaException, PosicionNoEncontradaException{
        if (!estaVacia()) {
            E dato = eliminarPosicion(0);
            return dato;
        }else{
            throw new ColaVaciaException();
        }
    }
}

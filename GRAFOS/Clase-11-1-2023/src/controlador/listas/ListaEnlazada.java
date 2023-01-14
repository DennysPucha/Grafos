package controlador.listas;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import java.lang.reflect.Array;

import utilidades.Utilidades;


public class ListaEnlazada <E> {
    private NodoLista<E> cabecera;
    private Integer tamanio;
    
    public ListaEnlazada(){
        cabecera = null;
        tamanio = 0;
    }
    
    public Boolean estaVacia(){
        return cabecera == null;
    }
    
    /*private Integer tamanio(){
        Integer tamanio = 0;
        NodoLista<E> aux = cabecera;
        
        while (aux != null) {
            tamanio++;
            aux = aux.getSiguiente();
        }
        
        return tamanio;
    }*/
    
    public void insertar(E dato){
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        
        if (estaVacia()) {
            this.cabecera = nodo;
        }else{
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
            
        }
        
        tamanio++;
    }
    
    public void imprimir(){
        System.out.println("Lista Enlazada");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
    }
    
    public void insertarCabecera(E dato){
        if (estaVacia()) {
            insertar(dato);
        }else{
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            tamanio++;
        }
    }
    
    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException{
        if(estaVacia()){
            insertar(dato);
        }else if (pos >= 0 && pos < tamanio){
            if (pos == 0){
                insertar(dato);
            }else{
                NodoLista<E> nodo = new NodoLista<>(dato, null);
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                tamanio++;
            }
        //}else if(pos == tamanio){
            //insertar(dato);
        }else {
            throw new PosicionNoEncontradaException();
        }
    }
    
    
    public E obtener(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException{
        
        if(!estaVacia()){
            E dato = null;
            if(pos >= 0 && pos < tamanio){
                if (pos == 0){
                    dato = cabecera.getDato();
                }else{
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    } 
                    dato = aux.getDato();
                }
            }else{
                throw new PosicionNoEncontradaException();
            } 
            return dato;
        }else{
          throw new ListaVaciaException();  
        } 
            
                
        //return dato;
    }
    
    public E eliminarPosicion(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException{
        if(!estaVacia()){
            E dato = null;
            if(pos >= 0 && pos < tamanio){
                if (pos == 0){
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    this.tamanio--;
                }else{
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    } 
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    tamanio--;
                }
            }else 
                throw new PosicionNoEncontradaException();
            return dato;
        }else 
            throw new ListaVaciaException();
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getTamanio() {
        //this.tamanio = tamanio();
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }
        
    public E[] toArray(){
        //Class<E> clazz=(Class<E>) ;
        E[] matriz =null;
        if (this.tamanio>0) {
            matriz=(E[])Array.newInstance(cabecera.getDato().getClass(),this.tamanio);
            NodoLista<E> aux=cabecera;
            for (int i = 0; i < this.tamanio; i++) {
                matriz[i]=aux.getDato();
                aux=aux.getSiguiente();
            }
        }
        return matriz;
    }
    
    public ListaEnlazada<E> toList(E[] array){
        this.vaciar();
        for (int i = 0; i < array.length; i++) {
            insertar(array[i]);
        }
        return this;
    }
    
    public void vaciar(){
        this.cabecera=null;
        setTamanio(0);
    }
    
    public ListaEnlazada<E> burbuja(){
        Class<E> clazz=null;
        E[] matriz=toArray();
        if (tamanio>0) {
            clazz=(Class<E>)cabecera.getDato().getClass();
            Boolean isObject=Utilidades.isObject(clazz);
            if (isObject) {
            }else{
                for (int i = matriz.length; i > 1; i--) {
                    for (int j = 0; j < i-1; j++) {
                        E auxJ=matriz[j];
                        E auxJ1=matriz[j+1];
                        if (Utilidades.isNumber(clazz)) {
                            if(((Number)auxJ).doubleValue()>((Number)auxJ1).doubleValue()){
                                matriz[j]=auxJ1;
                                matriz[j+1]=auxJ;
                            }
                        }
                        if (Utilidades.isString(clazz)) {
                            if(auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase())>0){
                                matriz[j]=auxJ1;
                                matriz[j+1]=auxJ;
                            }
                        }
                    }
                }
            }
        }
        if (matriz!=null) {
            toList(matriz);
        }
        return this;
    }
    
    public  ListaEnlazada<E> ShellAscendente(){
        Class<E> clazz=null;
        E[] arreglo=toArray();
        int salto=arreglo.length/2;
        int iterador1,iterador2;
        if (tamanio>0) {
            clazz=(Class<E>)cabecera.getDato().getClass();
            Boolean isObject=Utilidades.isObject(clazz);
            if (isObject) {
                
            }
            else{
                
                do {
            for (int i = salto; i < arreglo.length; i++) {
                iterador1=i-salto;
                    do {                    
                        iterador2=iterador1+salto;
                        if (Utilidades.isNumber(clazz)) {
                            if (((Number)arreglo[iterador1]).doubleValue()>((Number)arreglo[iterador2]).doubleValue()) {
                                E aux=arreglo[iterador1];
                                arreglo[iterador1]=arreglo[iterador2];
                                arreglo[iterador2]=aux;
                                iterador1=iterador1-salto;    
                            }else{
                                iterador1=-1;
                            }
                        }
                        if (Utilidades.isString(clazz)) {
                                if (arreglo[iterador1].toString().toLowerCase().compareTo(arreglo[iterador2].toString().toLowerCase())>0) {
                                E aux=arreglo[iterador1];
                                arreglo[iterador1]=arreglo[iterador2];
                                arreglo[iterador2]=aux;
                                iterador1=iterador1-salto; 
                                }else{
                                    iterador1=-1;
                            }
                        }
                    } while (iterador1>=0);                    
                }
                salto=salto/2;
            } while (salto>0);
            }
        }

        if (arreglo!=null) {
            toList(arreglo);
        }
        return this;   
    }
    public  ListaEnlazada<E> ShellDescendente(){
        Class<E> clazz=null;
        E[] arreglo=toArray();
        int salto=arreglo.length/2;
        int iterador1,iterador2;
        if (tamanio>0) {
            clazz=(Class<E>)cabecera.getDato().getClass();
            Boolean isObject=Utilidades.isObject(clazz);
            if (isObject) {
                
            }
            else{
                
                do {
            for (int i = salto; i < arreglo.length; i++) {
                iterador1=i-salto;
                    do {                    
                        iterador2=iterador1+salto;
                        if (Utilidades.isNumber(clazz)) {
                            if (((Number)arreglo[iterador1]).doubleValue()<((Number)arreglo[iterador2]).doubleValue()) {
                                E aux=arreglo[iterador1];
                                arreglo[iterador1]=arreglo[iterador2];
                                arreglo[iterador2]=aux;
                                iterador1=iterador1-salto;    
                            }else{
                                iterador1=-1;
                            }
                        }
                        if (Utilidades.isString(clazz)) {
                                if (arreglo[iterador1].toString().toLowerCase().compareTo(arreglo[iterador2].toString().toLowerCase())<0) {
                                E aux=arreglo[iterador1];
                                arreglo[iterador1]=arreglo[iterador2];
                                arreglo[iterador2]=aux;
                                iterador1=iterador1-salto; 
                                }else{
                                    iterador1=-1;
                            }
                        }
                    } while (iterador1>=0);                    
                }
                salto=salto/2;
            } while (salto>0);
            }
        }

        if (arreglo!=null) {
            toList(arreglo);
        }
        return this;   
    }
    
    
    public ListaEnlazada<E> llenarListaConDatos(Integer cantidadDeDatos,Class<E> tipoDeDato){
        vaciar();
        Class<E> clazz=(Class<E>)tipoDeDato;

        if (Utilidades.isNumber(clazz)) {
            if (tipoDeDato.getSimpleName().equalsIgnoreCase("Float")) {
                if (this.getTamanio()<cantidadDeDatos) {
                    for (int i = 0; i < cantidadDeDatos; i++) {
                        E random=(E) Float.valueOf((float)Math.random()); 
                        this.insertar(random);   
                    }
                }
            }
            if (tipoDeDato.getSimpleName().equalsIgnoreCase("Integer")) {
                if (this.getTamanio()<cantidadDeDatos) {
                    for (int i = 0; i < cantidadDeDatos; i++) {
                        E random=(E) Integer.valueOf((int)Math.random()); 
                        this.insertar(random);   
                    }
                }
            }
        }
        if (Utilidades.isString(clazz)) {
            String serie="AEIOUaeiouBCDFGHIJKLMN";
            String random="";
            for (int j = 0; j < cantidadDeDatos; j++) {
                for (int i = 0; i < 8; i++) {              
                    int max=8;
                    int min=1;
                    int rango=max-min+1;
                    int indice=(int)(Math.random()*rango)+min;
                    char rand=serie.charAt(indice);
                    random=random+rand;    
            }
                this.insertar((E) random);
                random="";
            }
            
            
    }
        return this;
}
    public void quicksortAscendente(){
        E[] arreglo=this.toArray();
        arreglo=OrdenamientoquicksortAscendente(arreglo, 0, arreglo.length-1);
        this.toList(arreglo);
    }
    public void quicksortDescendente(){
        E[] arreglo=this.toArray();
        arreglo=OrdenamientoquicksortDescendente(arreglo, 0, arreglo.length-1);
        this.toList(arreglo);
    }
    
    private E[] OrdenamientoquicksortAscendente(E[] arreglo,int primero,int ultimo){
        Class<E> clazz=null;
        int iterador1=primero;
        int iterador2=ultimo;
        E pivote=arreglo[(primero+ultimo)/2];
        if (tamanio>0) {
            clazz=(Class<E>)cabecera.getDato().getClass();
            Boolean isObject=Utilidades.isObject(clazz);
            if (isObject) {
            }else{
            if (Utilidades.isNumber(clazz)) {
                    while (iterador1<=iterador2) {            
                        while(((Number)arreglo[iterador1]).doubleValue()<((Number)pivote).doubleValue()){
                            iterador1=iterador1+1;
                        }
                        while(((Number)arreglo[iterador2]).doubleValue()>((Number)pivote).doubleValue()){
                            iterador2=iterador2-1;
                        }
                    if (iterador1<=iterador2){
                        E aux=arreglo[iterador1];
                        arreglo[iterador1]=arreglo[iterador2];
                        arreglo[iterador2]=aux;
                        iterador1=iterador1+1;
                        iterador2=iterador2-1;
                    }
                }
        //        this.imprimir();
                if (primero<iterador2) {
                    OrdenamientoquicksortAscendente(arreglo,primero,iterador2);
                }
                if (iterador1<ultimo) {
                    OrdenamientoquicksortAscendente(arreglo,iterador1,ultimo);
                }
            }
            if (Utilidades.isString(clazz)) {
                    while (iterador1<=iterador2) {            
                        while(arreglo[iterador1].toString().toLowerCase().compareTo(pivote.toString().toLowerCase())>0){
                            iterador1=iterador1+1;
                        }
                        while(arreglo[iterador2].toString().toLowerCase().compareTo(pivote.toString().toLowerCase())<0){
                            iterador2=iterador2-1;
                        }
                    if (iterador1<=iterador2){
                        E aux=arreglo[iterador1];
                        arreglo[iterador1]=arreglo[iterador2];
                        arreglo[iterador2]=aux;
                        iterador1=iterador1+1;
                        iterador2=iterador2-1;
                    }
                }
        //        this.imprimir();
                if (primero<iterador2) {
                    OrdenamientoquicksortAscendente(arreglo,primero,iterador2);
                }
                if (iterador1<ultimo) {
                    OrdenamientoquicksortAscendente(arreglo,iterador1,ultimo);
                }               
            }
            
            }
                 
        }
        return arreglo; 
    }
    private E[] OrdenamientoquicksortDescendente(E[] arreglo,int primero,int ultimo){
        Class<E> clazz=null;
        int iterador1=primero;
        int iterador2=ultimo;
        E pivote=arreglo[(primero+ultimo)/2];
        if (tamanio>0) {
            clazz=(Class<E>)cabecera.getDato().getClass();
            Boolean isObject=Utilidades.isObject(clazz);
            if (isObject) {
            }else{
            if (Utilidades.isNumber(clazz)) {
                    while (iterador1<=iterador2) {            
                        while(((Number)arreglo[iterador1]).doubleValue()>((Number)pivote).doubleValue()){
                            iterador1=iterador1+1;
                        }
                        while(((Number)arreglo[iterador2]).doubleValue()<((Number)pivote).doubleValue()){
                            iterador2=iterador2-1;
                        }
                    if (iterador1<=iterador2){
                        E aux=arreglo[iterador1];
                        arreglo[iterador1]=arreglo[iterador2];
                        arreglo[iterador2]=aux;
                        iterador1=iterador1+1;
                        iterador2=iterador2-1;
                    }
                }
        //        this.imprimir();
                if (primero<iterador2) {
                    OrdenamientoquicksortDescendente(arreglo,primero,iterador2);
                }
                if (iterador1<ultimo) {
                    OrdenamientoquicksortDescendente(arreglo,iterador1,ultimo);
                }
            }
            if (Utilidades.isString(clazz)) {
                    while (iterador1<=iterador2) {            
                        while(arreglo[iterador1].toString().toLowerCase().compareTo(pivote.toString().toLowerCase())<0){
                            iterador1=iterador1+1;
                        }
                        while(arreglo[iterador2].toString().toLowerCase().compareTo(pivote.toString().toLowerCase())>0){
                            iterador2=iterador2-1;
                        }
                    if (iterador1<=iterador2){
                        E aux=arreglo[iterador1];
                        arreglo[iterador1]=arreglo[iterador2];
                        arreglo[iterador2]=aux;
                        iterador1=iterador1+1;
                        iterador2=iterador2-1;
                    }
                }
        //        this.imprimir();
                if (primero<iterador2) {
                    OrdenamientoquicksortDescendente(arreglo,primero,iterador2);
                }
                if (iterador1<ultimo) {
                    OrdenamientoquicksortDescendente(arreglo,iterador1,ultimo);
                }        
            }
            
            }   
        }
        return arreglo;
    }
    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo.Exceptions;

/**
 *
 * @author Dennys
 */
public class VerticeOfSizeException extends Exception{
    public VerticeOfSizeException(String msg){
        super(msg);
    }
    public VerticeOfSizeException(){
        super("No se puede sobrepasar el numero de vertices");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.pilas.Exceptions;

/**
 *
 * @author leomah
 */
public class PilaVaciaException extends Exception{

    public PilaVaciaException(String string) {
        super(string);
    }
    
    public PilaVaciaException() {
        super("Pila vacía");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.colas.Exceptions;

/**
 *
 * @author leomah
 */
public class ColaVaciaException extends Exception{

    public ColaVaciaException(String string) {
        super(string);
    }

    public ColaVaciaException() {
        super("Cola vacia");
    }
}

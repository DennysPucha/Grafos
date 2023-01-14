/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.colas.Exceptions;

/**
 *
 * @author leomah
 */
public class ColaLlenaException extends Exception{

    public ColaLlenaException(String string) {
        super(string);
    }
    
    public ColaLlenaException() {
        super("Esta llena");
    }
    
}

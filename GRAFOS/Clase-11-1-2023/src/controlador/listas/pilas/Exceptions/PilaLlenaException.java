package controlador.listas.pilas.Exceptions;

public class PilaLlenaException extends Exception{

    public PilaLlenaException(String string) {
        super(string);
    }

    public PilaLlenaException() {
        super("La pila está llena");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import controlador.grafo.Exceptions.VerticeOfSizeException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennys
 */
public class GrafoNoDirigido extends GrafoDirigido{
    
    public GrafoNoDirigido(Integer numVertices) {
        super(numVertices);
    }

    @Override
    public void insertarArista(Integer O, Integer D, Double peso){
            if (O.intValue()<=getNumVertices() && D.intValue()<=getNumAristas()) {
                try {
                    if (!existeArista(O, D)) {
                        setNumAristas(getNumAristas()+1);
                        getListaAdyacente()[O].insertar(new Adyacencia(D, peso));
                        getListaAdyacente()[O].insertar(new Adyacencia(O, peso));
                        
                    }   } catch (Exception ex) {
                    Logger.getLogger(GrafoNoDirigido.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        
    }

    
    }
}

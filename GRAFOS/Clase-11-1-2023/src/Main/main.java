/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import controlador.grafo.GrafoDirigido;
import controlador.grafo.GrafoDirigidoEtiquetado;
import controlador.grafo.GrafoNoDirigido;
import controlador.grafo.GrafoNoDirigidoEtiquetado;
import vista.FmrGrafo;

/**
 *
 * @author Dennys
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        GrafoNoDirigido gnd=new GrafoNoDirigido(4);
//        System.out.println(gnd);
//        System.out.println("------------------------------");
//        try {
//            gnd.insertarArista(1, 3);
//            gnd.insertarArista(1, 4);
//            new FmrGrafo(null, true, gnd).setVisible(true);
//            System.out.println(gnd);
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//        }
//    }
        
        
//        GrafoDirigido gd=new GrafoDirigido(4);
//        System.out.println(gd);
//        System.out.println("------------------------------");
//        try {
//            gd.insertarArista(1, 3);
//            gd.insertarArista(1, 4);
//            gd.insertarArista(2, 3);
//            new FmrGrafo(null, true, gd).setVisible(true);
//            //System.out.println(gd);
//        } catch (Exception e) {
//            System.out.println("ERROR: "+e.getMessage());
//        }
//    } 
        GrafoDirigidoEtiquetado gde=new GrafoDirigidoEtiquetado(4,String.class);
        System.out.println(gde.toString());
        gde.etiquetarVertice(0,"LOL");
        gde.etiquetarVertice(1,"LOL1");
        gde.etiquetarVertice(2,"LOL2");
        gde.etiquetarVertice(3,"LOL3");
        gde.etiquetarVertice(4,"LOL4");
        try {

            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(0), gde.obtenerEtiqueta(1), 10.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(2), 20.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(4), 150.0);
            new FmrGrafo(null, true,gde).setVisible(true);
            System.out.println(gde.toString());
        } catch (Exception e) {
            
        }
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import controlador.listas.ListaEnlazada;
import java.lang.reflect.Field;

/**
 *
 * @author Dennys
 */
public class Utilidades {
    
//    public static ListaEnlazada<Float> llenarListaConFloat(ListaEnlazada<Float> lista,Integer cantidadDeDatos){
//        if (lista.getTamanio()<cantidadDeDatos) {
//            for (int i = 0; i < cantidadDeDatos; i++) {
//             Float random=Float.valueOf((float) Math.random());
//             lista.insertar(random);   
//            }
//        }
//        return lista;
//    }
        public static Field obtenerAtributos(Class clazz, String nombre){
        Field atributo = null;
        for (Field aux:clazz.getDeclaredFields()) {
            if(nombre.equalsIgnoreCase(aux.getName())){
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
    public static Boolean isNumber(Class clase){
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }
    
    public static Boolean isString(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("String");
    }
    
    public static Boolean isCharacter(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }
    
    public static Boolean isBoolean(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }
    
    public static Boolean isPrimitive(Class clase){
        return clase.isPrimitive();
    }
    
    public static Boolean isObject(Class clase){
        return (!isPrimitive(clase)&&!isBoolean(clase)&&!isCharacter(clase)&&!isNumber(clase)&&!isString(clase));
    }
}
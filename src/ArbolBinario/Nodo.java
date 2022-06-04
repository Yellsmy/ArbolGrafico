package ArbolBinario;

/**
 * Realizado por Yellsmy Wilson Eddison Roberto
 */

public class Nodo {
// metodos accesor private para que la clase 
// sea la unica que haga uso de este dato
    private int dato;
    private Nodo izq, der;
    
//constructor donde asignamos valor a las variables  dato, izq, der
//usamos THIS establece una referencia a las variables definidas 
    public Nodo(int dato, Nodo izq, Nodo der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }
    
//metodos get sirven para retornar el valor de la variable dato 
//asginado por el metodo set 
    public int getDato() {
        return dato;
    }
    
//metodo set sirve para asignar y modificar el valor de la variable dato  
    public void setDato(int dato) {// recibe el valor que se va asignar 
        this.dato = dato;//asignacion del valor 
    }
    
//metodos get sirven para retornar el valor del dato izquierdo
//asginado por el metodo set 
    public Nodo getIzq() {
        return izq;
    }
    
//metodo set sirve para asignar y modificar el valor del dato izquierdo 
    public void setIzq(Nodo izq) {// recibe el valor del puntero izquierdo
        this.izq = izq;//asignacion del valor 
    }
    
//metodos get sirven para retornar el valor del dato derecho
//asginado por el metodo set 
    public Nodo getDer() {
        return der;
    }
    
//metodo set sirve para asignar y modificar el valor del dato derecho
    public void setDer(Nodo der) {// recibe el valor del puntero derecho
        this.der = der;//asignacion del valor 
    } 
}

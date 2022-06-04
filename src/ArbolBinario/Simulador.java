package ArbolBinario;

/**
 *
 * Realizado por Yellsmy Wilson Eddison Roberto
 */
import java.util.ArrayList;
import javax.swing.JPanel;

//Instancia de metodos del ARBOL.java 
public class Simulador {
    //declaramos una variable arbol que nos da acceso a los metodos 
    Arbol miArbol = new Arbol();

    public boolean insertar(Integer dato) {
        //mediante la variable miArbol accedemos al metodo agregar
        //retornamos true de la funcion agregar despues de ejecutar 
        //la funcion recursiva insertar para que la interfaz 
        //ejecute complementos y repinte el entorno grafico 
        return (this.miArbol.agregar(dato));// return true 
    }

    //metodo recibe un entero el cual se borrara 
    public String borrar(Integer dato) {
        //mediante la variable miArbol accedemos al metodo borrar
        Integer x = this.miArbol.borrar(dato);
        if (x == null) {
            return ("No existe el dato en el arbol");
        }
        return ("Borrado el dato: " + x.toString());
    }

    public String preOrden() {
        //mediante la variable miArbol accedemos al metodo preOrden
        ArrayList it = this.miArbol.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }

    public String inOrden() {
        //mediante la variable miArbol accedemos al metodo inOrden
        ArrayList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }

    public String posOrden() {
        //mediante la variable miArbol accedemos al metodo postOrden
        ArrayList it = this.miArbol.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }

    public String imprimirPorNiveles() {
        //mediante la variable miArbol accedemos al metodo impNiveles 
        ArrayList it = this.miArbol.impNiveles();
        return (recorrido(it, "Imprimir Por niveles"));
    }

    public String darHojas() {
        //mediante la variable miArbol accedemos al metodo getHojas
        ArrayList it = this.miArbol.getHojas();
        return (recorrido(it, "Hojas del Arbol"));
    }

    public String esta(Integer dato) {
        //mediante la variable miArbol accedemos al metodo buscar
        boolean siEsta = this.miArbol.buscar(dato);
        String r = "El dato: " + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    private String recorrido(ArrayList it, String msg) {
        int i = 0;
//asigna el texto y con la expresion regula \n da un salto de pagina 
        String r = msg + "\n";
//recorre el arraylit para mostrar los datos 
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "\n";
            i++;
        }
        return (r);
    }
    public String porNivel(){
        //mediante la variable miArbol accedemos al metodo alturaArbol 
        this.miArbol.alturaArbol();
        //mediante la variable miArbol accedemos al metodo imprimirNivel 
        ArrayList it = this.miArbol.imprimirNivel();
        return (recorrido(it, "Niveles en Orden"));
    }
    
    public String CantidadNodos(){
        //mediante la variable miArbol accedemos al metodo cantidadNodos 
        return this.miArbol.cantidadNodos();
    }
    
    public String CantidadHojas(){
        //mediante la variable miArbol accedemos al metodo cantidadNodosHoja
        return this.miArbol.cantidadNodosHoja();
    }
   
    public JPanel getDibujo() {
        //mediante la variable miArbol accedemos al metodo getdibujo
        return this.miArbol.getdibujo();
    }
}

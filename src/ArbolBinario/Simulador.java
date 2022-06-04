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
    Arbol arbolBinario = new Arbol();

    public boolean insertarDato(Integer dato) {
        //mediante la variable arbolBinario accedemos al metodo agregarDato
        //retornamos true de la funcion agregarDato despues de ejecutar 
        //la funcion recursiva insertarDato para que la interfaz 
        //ejecute complementos y repinte el entorno grafico 
        return (this.arbolBinario.agregarDato(dato));// return true 
    }

    //metodo recibe un entero el cual se borrara 
    public String borrar(Integer dato) {
        //mediante la variable arbolBinario accedemos al metodo borrar
        Integer x = this.arbolBinario.borrar(dato);
        if (x == null) {
            return ("No existe el dato en el arbol");
        }
        return ("Borrado el dato: " + x.toString());
    }

    public String recorridoPreOrden() {
        //mediante la variable arbolBinario accedemos al metodo recorridoPreOrden
        ArrayList it = this.arbolBinario.recorridoPreOrden();
        return (recorrido(it, "Recorrido recorridoPreOrden"));
    }

    public String recorridoInOrden() {
        //mediante la variable arbolBinario accedemos al metodo recorridoInOrden
        ArrayList it = this.arbolBinario.recorridoInOrden();
        return (recorrido(it, "Recorrido recorridoInOrden"));
    }

    public String recorridoPostOrden() {
        //mediante la variable arbolBinario accedemos al metodo postOrden
        ArrayList it = this.arbolBinario.postOrden();
        return (recorrido(it, "Recorrido recorridoPostOrden"));
    }

    public String imprimirPorNiveles() {
        //mediante la variable arbolBinario accedemos al metodo impNiveles 
        ArrayList it = this.arbolBinario.impNiveles();
        return (recorrido(it, "Imprimir Por niveles"));
    }

    public String darHojas() {
        //mediante la variable arbolBinario accedemos al metodo getHojas
        ArrayList it = this.arbolBinario.getHojas();
        return (recorrido(it, "Hojas del Arbol"));
    }

    public String esta(Integer dato) {
        //mediante la variable arbolBinario accedemos al metodo buscarDato
        boolean siEsta = this.arbolBinario.buscarDato(dato);
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
        //mediante la variable arbolBinario accedemos al metodo alturaArbol 
        this.arbolBinario.alturaArbol();
        //mediante la variable arbolBinario accedemos al metodo imprimirNivel 
        ArrayList it = this.arbolBinario.imprimirNivel();
        return (recorrido(it, "Niveles en Orden"));
    }
    
    public String CantidadNodos(){
        //mediante la variable arbolBinario accedemos al metodo cantidadNodos 
        return this.arbolBinario.cantidadNodos();
    }
    
    public String CantidadHojas(){
        //mediante la variable arbolBinario accedemos al metodo cantidadNodosHoja
        return this.arbolBinario.cantidadNodosHoja();
    }
   
    public JPanel getDibujo() {
        //mediante la variable arbolBinario accedemos al metodo getdibujo
        return this.arbolBinario.getdibujo();
    }
}

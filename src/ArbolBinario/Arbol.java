package ArbolBinario;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * Realizado por Yellsmy Wilson Eddison Roberto
 */

//Metodos del arbol binario usados en el simuladorArbol
public class Arbol {
    // se estable la raiz del arbol binario 
    private Nodo raiz;
    // variable para establecer la cantidad de nodos del arbol 
    int cant;
    // variable para asignar y obtener la altura del arbol 
    int altura;

    //metodo set sirve para asignar y modificar el valor de la variable raiz
    public void setRaiz(Nodo r) {
        this.raiz = r;
    }
        
    //metodos get sirve para retornar el valor de la raiz del arbol  
    public Nodo getRaiz() {
        return this.raiz;
    }

    //constructor donde inicializamos la raiz
    public Arbol() {
        this.raiz = null;
    }
    // agrega un elemento nuevo al nodo instancia la funcion recursiva insertarDato y devuelve true 
    // para ejecutar los repintar los complementos graficos 
    public boolean agregarDato(int dato) {
        Nodo nuevo = new Nodo(dato, null, null);
        insertarDato(nuevo, raiz);
        return true;
    }

    public void insertarDato(Nodo nuevo, Nodo pivote) {
        //si esto es nulo entonces se creara la raiz 
        if (this.raiz == null) {
            raiz = nuevo;
            //caso contrario utiliza la raiz como pivote para determinar si un elemento
            //va delado izquierdo o derecho 
        } else {
            //si el nuevo dato ingresa es menor o igual al dato de la raiz
            //evalua si el dato de la izquierda esta vacio 
            if (nuevo.getDato() <= pivote.getDato()) {
                // si el dato de la izquierda esta vacio asigna el dato nuevo a la izquierda
                if (pivote.getizq() == null) {
                    
                    pivote.setizq(nuevo);
                    //caso contrario utiliza el valor de la izquierda 
                    //como pivote y ejecutamos la recursividad de la funcion
                } else {
                    
                    insertarDato(nuevo, pivote.getizq());
                }
            //en caso de nuevo valor sea mayo a la raiz entonces 
            //evaluar si el dato de la derecha esta vacio 
            } else {
                // el dato de la derecha esta vacio asigna el dato nuevo a la derecha
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                    //caso contrario utiliza el valor de la derecha 
                    //como pivote y ejecutamos la recursividad de la funcion
                } else {
                    insertarDato(nuevo, pivote.getDer());
                }
            }
        }
    }
    
    //cantidad de nodos del arbol
    public String cantidadNodos() {
        //contador globlar de nodos inicializa en cero 
        cant = 0;
        //ejecutamos funcion recursiva que incrementa el contador 
        cantidadNodos(raiz);
        return "Cantidad de Nodos: "+cant;
    }

    //metodo accesor private solo es accesible mediante la clase 
    private void cantidadNodos(Nodo reco) {
        //si el nodo recolectado es diferente de nulo entonces incrementa 
        //el contador global 
        if (reco != null) {
            cant++;
            //ejecutamos recursividad y pasamos a recolectar los nodos izquierda y derecha
            cantidadNodos(reco.getizq());
            cantidadNodos(reco.getDer());
        }
    }

    //cantidad nodos hoja
    public String cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(raiz);
        return "Cantidad de Hojas: "+cant;
    }
    
    private void cantidadNodosHoja(Nodo reco) {
        if (reco != null) {
            if (reco.getizq() == null && reco.getDer() == null) {
                cant++;
            }
            cantidadNodosHoja(reco.getizq());
            cantidadNodosHoja(reco.getDer());
        }
    }

    //imprimir ordenado con niveles
    String[] niveles;

    public int alturaArbol() {
        altura = 0;
        alturaArbol(raiz, 0);
        return altura;
    }

    private void alturaArbol(Nodo pivote, int nivel) {
        if (pivote != null) {
            alturaArbol(pivote.getizq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            alturaArbol(pivote.getDer(), nivel + 1);
        }
    }
//ArrayList se utiliza para almacenar una colección de elementos de tamaño dinámico
    public ArrayList imprimirNivel() {
        niveles = new String[altura + 1];
        ArrayList l=new ArrayList();
        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            l.add(niveles[i] + " ");
        }
        return l;
    }
    
      public void imprimirNivel(Nodo pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.getDato() + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.getDer(), nivel2 + 1);
            imprimirNivel(pivote.getizq(), nivel2 + 1);
        }
    }
//Se llama el metodo para pasarle un parametro entero 
//Borrar el que sea atraves de la referncia this de la raiz y el setter 

    public int borrar(int x) {
        if (!this.buscarDato(x)) {
            return 0;
        }
//hace uso de metodo private borrar 
        Nodo z = borrar(this.raiz, x);
        this.setRaiz(z);
        return x;
    }
// funcion con metodo accesor private 
    private Nodo borrar(Nodo r, int x) {

        if (r == null) {
            return null;//<--Dato no encontrado		
        }
//compara el dato obtenido de la raiz con el valor que se pasa por el parametro publico 
// para poder determinar que valor replaza segun el lado 
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {

            r.setizq(borrar(r.getizq(), x));
        } else if (compara < 0) {
            r.setDer(borrar(r.getDer(), x));
        } else {
            System.out.println("Encontro el dato:" + x);
            if (r.getizq() != null && r.getDer() != null) {
                /*
                 *	buscarDato el menor de los derechos y lo intercambia por el dato
                 *	que desea borrar. La idea del algoritmo es que el dato a borrar 
                 *	se coloque en una hoja o en un nodo que no tenga una de sus ramas.
                 **/
                Nodo cambiar = buscarDatoMin(r.getDer());
                int aux = cambiar.getDato();
                cambiar.setDato(r.getDato());
                r.setDato(aux);
                r.setDer(borrar(r.getDer(), x));
                System.out.println("2 ramas");
            } else {
                r = (r.getizq() != null) ? r.getizq() : r.getDer();
                System.out.println("Entro cuando le faltan ramas ");
            }
        }
        return r;
    }

//buscarDato recibe el valor a buscarDato
//dentro del metodod accesor 
    public boolean buscarDato(int x) {
        return (buscarDato(this.raiz, x));
    }
//recibe el valor entero recibi del metodo publico y la raiz 
    private boolean buscarDato(Nodo r, int x) {
        if (r == null) {
            return (false);//retorna falso si este noseencuntra 
        }
//si el dato se encuntra el metodo retorna verdadero
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            return (buscarDato(r.getizq(), x));
        } else if (compara < 0) {
            return (buscarDato(r.getDer(), x));
        } else {
            return (true);
        }
    }

    //buscarDato min el valor minimo que se utiliza en la opcion borrar 
    private Nodo buscarDatoMin(Nodo r) {
        for (; r.getizq() != null; r = r.getizq());
        return (r);
    }
    
       //imprimir recorridoPreOrden
    public ArrayList recorridoPreOrden() {
        ArrayList l=new ArrayList();
        recorridoPreOrden(raiz,l);
        return l;
    }

    private void recorridoPreOrden(Nodo reco, ArrayList l) {
        if (reco != null) {
//add nos permite añadir un elemento al final del ArrayList
            l.add(reco.getDato() + " ");
            recorridoPreOrden(reco.getizq(),l);
            recorridoPreOrden(reco.getDer(),l);
        }
    }
    
    //imprimir recorridoInOrden
    public ArrayList recorridoInOrden() {
        ArrayList l=new ArrayList();
        recorridoInOrden(raiz,l);
        return l;
    }

    private void recorridoInOrden(Nodo reco,ArrayList l) {
        if (reco != null) {
            recorridoInOrden(reco.getizq(),l);
//add nos permite añadir un elemento al final del ArrayList
            l.add(reco.getDato() + " ");
            recorridoInOrden(reco.getDer(),l);
        }
    }

//imprimir post orden
    public ArrayList postOrden() {
        ArrayList l=new ArrayList();
        postOrden(raiz,l);
        return l;
    }

    private void postOrden(Nodo reco, ArrayList l) {
        if (reco != null) {
            postOrden(reco.getizq(),l);
            postOrden(reco.getDer(),l);
//add nos permite añadir un elemento al final del ArrayList
            l.add(reco.getDato() + " ");
        }
    }
    
    //con nivel
       public ArrayList impNiveles() {
        ArrayList l=new ArrayList();
        impNiveles(raiz, 1,l);
        return l;
    }

//muestra los niveles utilizando la funcion recursiva 
    private void impNiveles(Nodo reco, int nivel,ArrayList l) {
//si el valor es diferente de vacio 
        if (reco != null) {
//recibe el valor de lador izquirdo y suma uno al nivel para evaluar 
// los nuevos valores 
            impNiveles(reco.getizq(), nivel + 1, l);
//add nos permite añadir un elemento al final del ArrayList 
            l.add(reco.getDato() + " Nivel: (" + nivel + ") ");
//recibe el valor de lador derecho y suma uno al nivel para evaluar 
// los nuevos valores 
            impNiveles(reco.getDer(), nivel + 1, l);
        }
    }

//hojas 
    public ArrayList getHojas() {
        ArrayList l = new ArrayList();
        getHojas(this.raiz, l);
        return (l);
    }

    private void getHojas(Nodo r, ArrayList l) {
        if (r != null) {
            if (this.esHoja(r)) {
//add nos permite añadir un elemento al final del ArrayList
                l.add(r.getDato());
            }
            getHojas(r.getizq(), l);
            getHojas(r.getDer(), l);
        }
    }
    
    protected boolean esHoja(Nodo x) {
        return (x != null && x.getizq() == null && x.getDer() == null);
    }
       
    //dibujar arbol
     public JPanel getdibujo() {
        return new Grafica(this);
    }
}
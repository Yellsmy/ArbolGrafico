package ArbolBinario;

/**
 *
 * Realizado por Yellsmy Wilson Eddison Roberto
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Grafica extends JPanel 
{
    private Arbol miArbol;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0,0);
    private FontMetrics fm = null;
    
    
    /**
     * Constructor de la clase ArbolExpresionGrafico.
     * El constructor permite inicializar los atributos de la clase ArbolExpresionGrafico
     * y llama al método repaint(), que es el encargado de pintar el Arbol.
     * parametro miExpresion: dato de tipo ArbolExpresion que contiene el Arbol a
     * dibujar.
     */
    public Grafica(Arbol miArbol) 
    {
          this.miArbol = miArbol;
          this.setBackground(Color.WHITE); // Se le asigna color blanco al panel
          //Creamos 2 mapa hash. HashMap nos ayudará a contener todos los subárboles y posiciones
          posicionNodos = new HashMap();
          subtreeSizes = new HashMap();
          dirty = true;
          repaint();    
          /*
          La llamada a repaint() únicamente avisa a la máquina virtual java que ese componente necesita repintado.
          El método en sí mismo no borra ni dibuja nada. La máquina virtual encola dicha petición en su cola de eventos de pantalla,
          junto a eventos de teclado y ratón. Cuando llegue el momento,
          se comienza el redibujado en un hilo distinto, El hilo de awt.
          Cuando la máquina virtual decide repintar el componente, lo que hace es llamar a su método update(Graphics g).
          Este método, por defecto, borra el componente por completo, rellenándolo con un rectángulo relleno del tamaño de componente y del color de fondo.
          Inmediatamente después,
          el método update(Graphics g) llama al método paint(Graphics g).
          */
    }


    /**
     * Calcula las posiciones de los respectivos subárboles y de cada nodo que 
     * forma parte de ese subárbol, para conocer en que posición van a ir dibujados
     * los rectángulos representativos del árbol de la expresión.
     */
    private void calcularPosiciones() 
    {
         posicionNodos.clear(); //Limpia la posición de los nodos
         subtreeSizes.clear(); //Limpia el subarbol
         Nodo root = this.miArbol.getRaiz(); //creamos una variable que guardará la raiz del árbol      
         if (root != null) 
         {//Si la raíz no es nula, llama a los métodos para calcular el tamaño del subárbol 
         //y al método que nos dará la posición de cada nodo
             calcularTamañoSubarbol(root);
             calcularPosicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
         }
    }
    
    /**
     * Calcula el tamaño de cada subárbol y lo agrega al objeto subtreeSizes de la clase
     * de tipo HashMap que va a contener la coleccion de todos los 
     * subárboles que contiene un arbol.
     * parametro n:Objeto de la clase Nodo que se utiliza como
     * referencia calcular el tamaño de cada subárbol.
     * retorno de Dimension con el tamaño de cada subárbol.
     */
    private Dimension calcularTamañoSubarbol(Nodo n) 
    {     //Si el árbol está vacío retornará dimensiones altura y ancho 0 porque quiere decir que no
         //existe un árbol
          if (n == null) 
              return new Dimension(0,0);
          
          //sino, se ejecutará la recursividad creando variables de tipo Dimensión para recorrer el árbol
          //Del lado izquierdo y del lado derecho y lo guarda en las variables ld y rd respectivamente
          Dimension ld = calcularTamañoSubarbol(n.getIzq());
          Dimension rd = calcularTamañoSubarbol(n.getDer());
          
          //Creamos variable que sumará los datos:
          //fm.getHeight() nos ayudará a obtener la altura del texto, en este caso, del número
          //saca la altura máxima del lado izquierdo y derecho que se guardó en ld y rd anteriormente         
          int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
          
          //Creamos variable que sumará los datos:
          //El ancho de los datos izquierdos que fue guardado en ld anteriormente
          //El ancho de los datos derecho que fue guardado en rd anteriormente
          int w = ld.width + child2child + rd.width;
          
          //construye una dimensión que recibe el ancho "w" y la altura "h" que guardamos anteriormente
          //Para calcular el tamaño de cada subárbol
          Dimension d = new Dimension(w, h);
          
          //Utilizamos el método put() para almacenar un valor "d" y lo asocia con "n" que será la clave de ese valor
          //En este caso la clave es el nodo y el valor es el objeto d
          //De esta forma es como guarda el tamaño de cada subárbol
          //Y podrá ser recuperado en cualquier punto dado pasando el nodo que deseemos
          subtreeSizes.put(n, d);
          
          return d;
    }
    
    
    /**
     * Calcula la ubicación de cada nodo de cada subárbol y agrega cada nodo con 
     * un objeto de tipo Rectangule que tiene la ubicación y la información específica de dónde 
     * va a ser dibujado.
     * parametro n: Objeto de tipo Nodo que se utiliza como
     * referencia para calcular la ubicación de cada nodo.
     * parametro left: int con alineación y orientación a la izquierda.
     * parametro right: int con alineación y orientación a la derecha.
     * parametro top: int con el tope.
     */
    private void calcularPosicion(Nodo n, int left, int right, int top) 
    {
      //Si no hay datos en el árbol, sale de la función  
      if (n == null) 
          return;
      
      //Variable "ld" de tipo dimensión que guarda el valor asociado con la posición
      //izquierda que se pasa como clave y que fueron almacenadas en el método calcularPosiciones() 
      Dimension ld = (Dimension) subtreeSizes.get(n.getIzq());
      
      //Si el valor asociado almacenado en la posición izquierda es nulo,
      //"ld" guardará las dimensiones 0,0 que fueron iniciadas al inicio
      if (ld == null) 
          ld = empty;
      
      //Variable "rd" de tipo dimensión que guarda el valor asociado con la posición
      //derecha que se pasa como clave y que fueron almacenadas en el método calcularPosiciones()
      Dimension rd = (Dimension) subtreeSizes.get(n.getDer());
      
      //Si el valor asociado almacenado en la posición derecha es nulo,
      //"rd" guardará las dimensiones 0,0 que fueron iniciadas al inicio
      if (rd == null) 
          rd = empty;
      
      //El centro será cero
      int center = 0;
      
      //si la alineación y orientación a la derecha es diferente al valor máximo almacenado
      //el centro será el resultado de la resta entre la posición derecha, el ancho del elemento rd y
      //la división entre 2 del valor almacenado en child2child
      if (right != Integer.MAX_VALUE)
          center = right - rd.width - child2child/2;
      
      //si la alineación y orientación a la izquierda es diferente al valor máximo almacenado
      //el centro será el resultado de la suma entre la posición izquierda, el ancho del elemento ld y
      //la división entre 2 del valor almacenado en child2child
      else if (left != Integer.MAX_VALUE)
          center = left + ld.width + child2child/2;
      
      
      
      //Variable que guardará el ancho que tiene el valor almacenado en Dato, en este caso, el ancho del/los
      //número/s
      int width = fm.stringWidth(n.getDato()+"");
      
      //Utilizamos el método put() para almacenar un valor asociado a una clave
      //En este caso la clave será la ubicación del nodo n y el valor será un objeto Rectangle (un área en un espacio de coordenadas)
      //Que recibe cordenadas (x,y), un ancho "width" y una altura height
      //x: será el resultado de la resta entre el centro(valor guardado en la variable center) menos la mitad del ancho menos 3
      //y: será el int con el tope
      //width: será el resultado de la suma entre el ancho más 6
      //height: será la altura del texto en pixeles
      posicionNodos.put(n,new Rectangle(center - width/2 - 3, top, width + 6, fm.getHeight()));
      
      //proceso de dibujo recursivo 
      calcularPosicion(n.getIzq(), Integer.MAX_VALUE, center - child2child/2, top + fm.getHeight() + parent2child);
      calcularPosicion(n.getDer(), center + child2child/2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
    }
    
    /**
     * Dibuja el árbol teniendo en cuenta las ubicaciones de los nodos y los 
     * subárboles calculadas anteriormente.
     * parametro g: Objeto de la clase Graphics2D que permite realizar el dibujo de las líneas, rectangulos y del String de la información que contiene el Nodo.
     * parametro n: Objeto de la clase Nodo que se utiliza como referencia para dibujar el árbol.
     * parametro puntox: int con la posición en x desde donde se va a dibujar la línea hasta el siguiente hijo.
     * parametro puntoy: int con la posición en y desde donde se va a dibujar la línea hasta el siguiente hijo.
     * parametro altura: int con la altura del FontMetrics.
     */
    private void dibujarArbol(Graphics2D g, Nodo n, int puntox, int puntoy, int altura) 
    {//si la referencia para dibujar el árbol es nula, sale de la función
     if (n == null) 
         return;
     
     //Creamos una variable de tipo Rectangle que guardará el valor asociado a la clave "n" almacenado en el mapa hash
     Rectangle r = (Rectangle) posicionNodos.get(n);
     
     //Dibujamos el exterior del rectángulo donde está el nodo a dibujar en cual fue guardado en "r" 
     g.draw(r);
     
     //Escribe o "dibuja" un string en este caso sería el valor de dato,
     //con las cordenadas específicas (string, x, y)
     //string: el dato del nodo que se va a dibujar
     //x: resultado de la suma entre la posición en x que fue almacenada en posicionNodos más 3
     //y: resultado de la suma entre la posición en y que fue almacenada en posicionNodos más la altura del FontMetrics
     g.drawString(n.getDato()+"", r.x + 3, r.y + altura);
   
     //si desde donde se va a dibujar la línea hasta el siguiente hijo es diferente al valor mayor
     
     if (puntox != Integer.MAX_VALUE)
      
     //se dibujará una linea desde las cordenadas (x,y) hasta la segunda cordenada (x2,y2)
     //x: posición x que se pasa como parámetro
     //y: posición y que se pasa como parámetro
     //x2: resultado de la suma entre la posición x que fue almacenada en posicionNodos más la mitad del ancho del valor
     //y2: posición en y que fue almacenada en posicionNodos
     g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);
     
     
     //Proceso recursivo para dibujar el árbol por el lado izquierdo y derecho
     dibujarArbol(g, n.getIzq(), (int)(r.x + r.width/2), r.y + r.height, altura);
     dibujarArbol(g, n.getDer(), (int)(r.x + r.width/2), r.y + r.height, altura);
     
   }
    
   /**
     * Sobreescribe el metodo paint y se encarga de pintar todo el árbol.
     * parametro g: Objeto de la clase Graphics.
     */
   public void paint(Graphics g) 
   {
       //Pinta el recipiente reenviando la pintura a cualquier componente ligero que sea hijo de este contenedor
         super.paint(g);
         //obtenemos las características de la fuente
         fm = g.getFontMetrics();

         //si dirty es true quiere decir que no se han calculado las posiciones,
         //por lo que se llama al método calcularPosiciones() y dirty se convierte en false
         if (dirty) 
         {
           calcularPosiciones();
           dirty = false;
         }
         
         //Variable de tipo Graphics2D que almacenará el objeto que se pasará como parámetro
         Graphics2D g2d = (Graphics2D) g;
         
         //
         g2d.translate(getWidth() / 2, parent2child);
         
         //Se llama al método para dibujar el árbol
         //g2d: variable declarada anteriormente
         //la raíz del árbol
         //El valor máximo que se ha guardado en cualquier variable entera
         //fm.getLeading: la distancia de la el borde superior y el el punto alto del número
         //fm.getAscent: El espacio que ocupa el número sin bordes superiores o inferiores
         dibujarArbol(g2d, this.miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, 
                  fm.getLeading() + fm.getAscent());
         fm = null;
   }
 }
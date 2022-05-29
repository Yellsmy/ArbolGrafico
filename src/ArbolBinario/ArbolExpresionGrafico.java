package ArbolBinario;

/**
 *
 * Realizado por Yellsmy Wilson Eddison Roberto
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ArbolExpresionGrafico extends JPanel 
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
    public ArbolExpresionGrafico(Arbol miArbol) 
    {
          this.miArbol = miArbol;
          this.setBackground(Color.WHITE); // Se le asigna color blanco al panel
          //guardar valores nulos en cualquier lugar 
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
         subtreeSizes.clear(); //Limpia el arbol
         Nodo root = this.miArbol.getRaiz();
         //Si la raíz no es nula, llama a los métodos para calcular el tamaño del subárbol 
         //y al método que nos dará la posición de cada nodo
         if (root != null) 
         {
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
    //El método retornará un objeto dimensión que es una clase de la librería awt
    private Dimension calcularTamañoSubarbol(Nodo n) 
    {     //Si el árbol está vacío retornará dimensiones altura y ancho 0
          if (n == null) 
              return new Dimension(0,0);
          
          //sino se ejecutará la recursividad creando variables de tipo Dimensión para recorrer el árbol
          //Del lado izquierdo y del lado derecho y lo guarda en las variables ld y rd respectivamente
          Dimension ld = calcularTamañoSubarbol(n.getIzq());
          Dimension rd = calcularTamañoSubarbol(n.getDer());
          
          //Creamos variables para guardar 
          //fm.getHeight() nos ayudará a obtener la altura del texto, en este caso, del número
          //parent2child ni idea XD
          //saca la altura máxima del lado izquierdo y derecho que se guardó en ld y rd anteriormente         
          int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
          
          //El ancho de los datos izquierdo que fue guardado en ld anteriormente
          //child2child ni idea x2
          //El ancho de los datos derecho que fue guardado en rd anteriormente
          int w = ld.width + child2child + rd.width;
          
          //inicializamos un nuevo objeto con el ancho y la altura que guardamos en w y h
          Dimension d = new Dimension(w, h);
          
          //Utilizamos el método put() para insertar una nueva clave y un nuevo valor
          //En este caso la clave es el nodo y el valor es el objeto d
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
        
      if (n == null) 
          return;
          
      Dimension ld = (Dimension) subtreeSizes.get(n.getIzq());
      if (ld == null) 
          ld = empty;
      
      Dimension rd = (Dimension) subtreeSizes.get(n.getDer());
      if (rd == null) 
          rd = empty;
      
      int center = 0;
      
      if (right != Integer.MAX_VALUE)
          center = right - rd.width - child2child/2;
      else if (left != Integer.MAX_VALUE)
          center = left + ld.width + child2child/2;
      int width = fm.stringWidth(n.getDato()+"");
      //utilizamos el hasmap para hacer referencia a un elemento nulo el cual recibe el n valor nodo de las funciones get creando un rectangulo con ancho alto altura 
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
    {
     if (n == null) 
         return;
     
     //Creamos una variable de tipo Rectangle que guardará un objeto 
     Rectangle r = (Rectangle) posicionNodos.get(n);
     
     //Dibujamos 
     g.draw(r);
     
     //Escribe un string en este caso sería el valor de dato, con las cordenadas específicas
     g.drawString(n.getDato()+"", r.x + 3, r.y + altura);
   
     if (puntox != Integer.MAX_VALUE)
       
     g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);
     
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
         //definicion de un objeto de métricas de fuente
         fm = g.getFontMetrics();

         if (dirty) 
         {
           calcularPosiciones();
           dirty = false;
         }
         
         Graphics2D g2d = (Graphics2D) g;
         g2d.translate(getWidth() / 2, parent2child);
         dibujarArbol(g2d, this.miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, 
                  fm.getLeading() + fm.getAscent());
         fm = null;
   }
 }
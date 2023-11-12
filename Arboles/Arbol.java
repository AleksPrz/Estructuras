public class Arbol <T> {
  private NodoArbol <T> raiz;
  private boolean esBinario = false;

  /**
   * Crea un árbol con un nodo raíz 
   * @param dato el dato que almacenara el nodo raiz
   * @param esBinario true si el arbol será binario, false si será un arbol general
   */
  public Arbol (T dato, boolean esBinario) {
    raiz = new NodoArbol <T> (dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  public NodoArbol <T> obtenerRaiz() {
    return raiz;
  }

  public boolean esBinario() {
    return esBinario;
  }

  /**
   * Agrega un nodo hijo a un nodo
   * @param nodoRaiz nodo padre
   * @param nodoAgregado nodo que se añadirá como hijo al nodo padre
   */
  public void agregarNodoArbol(NodoArbol <T> nodoRaiz, NodoArbol <T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /**
   * Imprime todos los datos de cada nodo del árbol en una líea siguiendo la notación dada.
   * Cada dato está separado por /tab
   * @param recorrido notación en la que se quiere la impresión
   */
  public void imprimirArbol(Recorrido recorrido) {
    imprimirSubArbol(raiz, recorrido);
    
    /* Código original
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");
        raiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;
    
      default:
        break;
    }
    */
  }
  

  //AÑADIDOS
  public boolean estaVacio(){
    return raiz == null;
  }
  
  /**
   * Retorna la altura de todo el arbol
   * @return altura del árbol
   */
  public int obtenerAltura(){
    if(estaVacio()) return 0;
    return contarAltura(raiz);
    
  }

  /**
   * Retorna la altura del subarbol a partir del nodo raíz dado. 
   * Para obtener altura máxíma, examina el tamaño de cada rama y usa la más alta
   * @param raiz nodo a partir del cual se empezará a contar la altura
   * @return el tamaño de la rama mas grande de la raiz más 1 (más la raíz misma)
   */
  private int contarAltura(NodoArbol<T> raiz){
    NodoArbol <T> hijo = raiz.obtenerPrimerHijo();
    if (hijo == null){ //Si ya no hay nodos hijos, solo se suma el nodo actual
      return 1;
    }
    
    //Cuenta primero la altura de la rama del primer hijo
    int alturaMaxima = contarAltura(hijo);
     
    //Empieza a iterar entre todos sus otros hijos para comparar y obtener la altura de la rama más larga
    while(hijo.obtenerSiguienteHermano() != null){
      hijo = hijo.obtenerSiguienteHermano();
      int alturaHermano = contarAltura(hijo);
      if (alturaHermano > alturaMaxima){
        alturaMaxima = alturaHermano;
      }
    }
    //Retorna el nodo raíz + la altura de la rama más larga
    return 1 + alturaMaxima;
  }

  /**
   * Imprime los nodos del subarbol a partir del nodo ingresado
   * @param nodoRaiz el nodo raíz del subarbol
   * @param recorrido notación en la que se quiere la impresión
   */
  public void imprimirSubArbol(NodoArbol <T> nodoRaiz, Recorrido recorrido){
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");
        nodoRaiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        nodoRaiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        nodoRaiz.imprimirEnPosfijo();
        break;
    
      default:
        break;
    }
  }
}
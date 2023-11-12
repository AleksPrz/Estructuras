public class NodoArbol <T> {
  private T dato;
  private boolean esBinario = false;
  private NodoArbol <T> primerHijo;
  private NodoArbol <T> siguienteHermano;
  
  /**
   * Crea un nodo sin conexiones a otros nodos
   * @param dato dato que se almacenará en el nodo
   */
  public NodoArbol (T dato) {
    this.dato = dato;
    primerHijo = null;
    siguienteHermano = null;
  }

  /**
   * Añade un nodo hijo a este nodo. 
   * Si el nodo no tiene hijos, añade una referencia directa al nuevo nodo con la variable primerHijo.
   * Cuando el nodo ya tiene un hijo, añade el nodo nuevo como una referencia siguienteHermano al nodo primerHijo de este nodo.
   * 
   * Si el nodo es binario, el nuevo nodo hijo también lo será, por tanto, si el nodo padre ya tiene 2 hijos, no 
   * se agregará el nuevo nodo y mostrará un mensaje de error en pantalla
   * @param hijo nodo que se añade como hijo
   */
  public void agregarHijo (NodoArbol <T> hijo) {
    if (primerHijo == null) {
      primerHijo = hijo;
    } else {
      NodoArbol<T> hermano = this.primerHijo;

      if (esBinario) {
        if (hermano.siguienteHermano != null) { //Si el primero hijo ya tiene un hermano, el nodo ya tiene dos hijos
          System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());	
        } else {
          hermano.siguienteHermano = hijo;
        }
      } else {
        while (hermano.siguienteHermano != null) { //Itera desde el nodo primerHijo hasta el ultimo hermano añadido
          hermano = hermano.siguienteHermano;
        }
        hermano.siguienteHermano = hijo;
      }      
    }
  }

  public NodoArbol<T> obtenerPrimerHijo () {
    return primerHijo;
  }

  public NodoArbol<T> obtenerSiguienteHermano () {
    return siguienteHermano;
  }

  public T getDato () {
    return dato;
  }

  public boolean esBinario () {
    return esBinario;
  }

  public void setEsBinario (boolean esBinario) {
    this.esBinario = esBinario;
  }

  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }

  public void imprimirEnInfijo() {
    NodoArbol<T> hijo = primerHijo;

    if (hijo != null) {
      hijo.imprimirEnInfijo();
    }

    System.out.print(dato + "\t");
    while (hijo != null) {
      hijo = hijo.siguienteHermano;
      if (hijo != null) {
        hijo.imprimirEnInfijo();
      }
    }
  }

  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}

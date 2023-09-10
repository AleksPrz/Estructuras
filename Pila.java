public class Pila {
    private Nodo cima;
    private int tamanio;
    
    public Pila(){
        tamanio = 0;
    }
    
    public void insertar(int dato){
        Nodo nuevo = new Nodo(dato);
        if(!estaVacia())
            nuevo.setNodo(cima);
        cima = nuevo;
            
        tamanio++;
        }
    
    public void quitar(){
        cima = cima.getNodo();
        tamanio--;
    }
    
    public boolean estaVacia(){
        return tamanio <= 0;
    }
    
    public void vaciar(){
        cima = null;
        tamanio = 0;
    }
    
    public int obtenerCima(){
        return cima.getDato();
    }
    
    public int getTamanio(){
        return tamanio;
    }
}

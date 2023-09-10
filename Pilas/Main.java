public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();
        int datos[] = {14,27,1,15,10,90,71,37,2,48};
        for(int i:datos)
            pila.insertar(i);
        
        System.out.println("El tamano de la pila es "+ pila.getTamanio());
        for(int i=0; i<4; i++)
            pila.quitar();
        
        System.out.println("El dato en la cima es: " + pila.obtenerCima());
        
        pila.vaciar();
        if(pila.estaVacia())
            System.out.println("La pila esta vacia");
        
    }
}

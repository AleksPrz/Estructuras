public class Main {
    public static void main(String[] args) {
        ListaSimplementeEnlazada listaSimple = new ListaSimplementeEnlazada();
        
        int valores[] = {5,59,91,-17,73,34,40};
        for(int valor:valores)
            listaSimple.insertar(valor);
        
        listaSimple.eliminar(2);
        listaSimple.eliminar(3);
        
        System.out.println(listaSimple.obtener(3));
        
    }
}

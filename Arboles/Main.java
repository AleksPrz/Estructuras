public class Main {
    public static void main(String[] args) {
    //IMPLEMENTACION DEL ARBOL GENERAL
        NodoArbol<Character>[] nodos = new NodoArbol[16];
                         //   0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15
        Character[] datos = {'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'};
        
        for(int i = 0; i < datos.length; i++){
            nodos[i] = new NodoArbol<Character>(datos[i]);
        }
        
        Arbol<Character> arbolGeneral = new Arbol<>('A',false);
        //A
        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodos[0]); //B
        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodos[1]); //C
        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodos[2]); //D
        //B
        arbolGeneral.agregarNodoArbol(nodos[0], nodos[3]); //E
        arbolGeneral.agregarNodoArbol(nodos[0], nodos[4]); //F
        //D
        arbolGeneral.agregarNodoArbol(nodos[2], nodos[5]); //G
        arbolGeneral.agregarNodoArbol(nodos[2], nodos[6]); //H
        arbolGeneral.agregarNodoArbol(nodos[2], nodos[7]); //I
        //F
        arbolGeneral.agregarNodoArbol(nodos[4], nodos[8]); //J
        arbolGeneral.agregarNodoArbol(nodos[4], nodos[9]); //K
        arbolGeneral.agregarNodoArbol(nodos[4], nodos[10]); //L
        //G
        arbolGeneral.agregarNodoArbol(nodos[5], nodos[11]); //M
        //I
        arbolGeneral.agregarNodoArbol(nodos[7], nodos[12]); //N
        arbolGeneral.agregarNodoArbol(nodos[7], nodos[13]); //O
        //M
        arbolGeneral.agregarNodoArbol(nodos[11], nodos[14]); //P
        arbolGeneral.agregarNodoArbol(nodos[11], nodos[15]); //Q
        
        System.out.println("ARBOL GENERAL");
        arbolGeneral.imprimirArbol(Recorrido.PREFIJO);
        arbolGeneral.imprimirArbol(Recorrido.INFIJO);
        arbolGeneral.imprimirArbol(Recorrido.POSFIJO);
        System.out.println("\n¿El arbol esta vacio? " + arbolGeneral.estaVacio());
        System.out.println("La altura del arbol es: " + arbolGeneral.obtenerAltura());

    //IMPLEMENTACIÓN DEL ÁRBOL BINARIO
        for(int i = 0; i < datos.length; i++){
            nodos[i] = new NodoArbol<Character>(datos[i]);
        }
        Arbol<Character> arbolBinario = new Arbol<>('A',true);

        //A
        arbolBinario.agregarNodoArbol(arbolBinario.obtenerRaiz(), nodos[0]); //B
        //B
        arbolBinario.agregarNodoArbol(nodos[0], nodos[3]); //E
        arbolBinario.agregarNodoArbol(nodos[0], nodos[1]); //C
        //C
        arbolBinario.agregarNodoArbol(nodos[1], nodos[2]); //D
        //D
        arbolBinario.agregarNodoArbol(nodos[2], nodos[5]); //G
        //E
        arbolBinario.agregarNodoArbol(nodos[3], nodos[4]); //F
        //F
        arbolBinario.agregarNodoArbol(nodos[4], nodos[8]); //J
        //G
        arbolBinario.agregarNodoArbol(nodos[5], nodos[11]); //M
        arbolBinario.agregarNodoArbol(nodos[5], nodos[6]); //H
        //H
        arbolBinario.agregarNodoArbol(nodos[6], nodos[7]); //I
        //I
        arbolBinario.agregarNodoArbol(nodos[7], nodos[12]); //N
        //J
        arbolBinario.agregarNodoArbol(nodos[8], nodos[9]); //K
        //K
        arbolBinario.agregarNodoArbol(nodos[9], nodos[10]); //L
        //M
        arbolBinario.agregarNodoArbol(nodos[11], nodos[14]); //P
        //N
        arbolBinario.agregarNodoArbol(nodos[12], nodos[13]); //O
        //P
        arbolBinario.agregarNodoArbol(nodos[14], nodos[15]); //Q

        System.out.println("\nARBOL BINARIO");
        arbolBinario.imprimirArbol(Recorrido.PREFIJO);
        arbolBinario.imprimirArbol(Recorrido.INFIJO);
        arbolBinario.imprimirArbol(Recorrido.POSFIJO);
        System.out.println("\n¿El arbol esta vacio? " + arbolBinario.estaVacio());
        System.out.println("La altura del arbol es: " + arbolBinario.obtenerAltura());
        
        //IMPLEMENTACION IMPRIMIR SUBARBOL
        System.out.println("\nSubarbol con raíz 'F' en notación prefija: ");
        arbolBinario.imprimirSubArbol(nodos[4], Recorrido.PREFIJO);
    }
}
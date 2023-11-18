from ArbolB import ArbolB

arbol = ArbolB()
arbol.insertar(4,10,8,3,7,12,2,30)
arbol.imprimir_arbol()

arbol.buscar(10)
arbol.buscar(44)

arbol.eliminar(8)

arbol.imprimir_arbol()

arbol.eliminar(3)

arbol.imprimir_arbol()

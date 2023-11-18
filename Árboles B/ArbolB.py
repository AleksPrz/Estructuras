import math
class NodoArbolB:
    def __init__(self, es_hoja=False):
        self.claves = []
        self.hijos = []
        self.es_hoja = es_hoja
    
    def imprimir(self, nodo):
        for i in nodo.claves:
            if i != (None, None):
                print(i, end=" ")
        if not nodo.es_hoja:
            for i in nodo.hijos:
                nodo.imprimir(i)

'''
El grado de un arbol T representa el numero maximo de hijos que puede tener cada nodo.
Cada nodo tiene ente (grado /2) y (grado - 1) claves
Todas las hojas estan al mismo nivel.
Las inserciones ocurren en las hojas, si el numero de claves excede el limite (grado - 1), ocurre una division
'''
class ArbolB:

    def __init__(self, grado = 4): #El arbol tiene un grado predeterminado de 4
        self.raiz = NodoArbolB(True)
        self.t = math.ceil(grado/2)    # t representa el numero minimo de hijos (grado/2)
    
    '''
    Recibe el valor que se anadira al arbol. Si la raiz esta llena, la divide y crea una nueva raiz.
    Inserta el valor en el arbol
    '''
    def insertar(self, *claves):
        for clave in claves:
            raiz = self.raiz
            if len(raiz.claves) == (2 * self.t) - 1:    #Si la raiz esta llena
                temporal = NodoArbolB() #Se crea una nueva raiz
                self.raiz = temporal
                temporal.hijos.insert(0, raiz) #La anterior raiz sera el hijo izquierdo de la nueva raiz
                self.dividir(temporal, 0)   #Divide la anterior raiz en dos
                self.insercion_ordenada(temporal, clave)
            else:
                self.insercion_ordenada(raiz, clave)
    
    '''
    insercion_ordenada es llamada para ingresar una clave en un nodo que se sabe que no esta lleno
    Se encarga de buscar el lugar donde insertar la clave y reacomodar todos los demas valores
    '''
    def insercion_ordenada(self, nodo, clave):
        i = len(nodo.claves) - 1
        if nodo.es_hoja:
            nodo.claves.append((None, None)) #Anade un espacio en la lista para evitar un desbordamiento
            
            while i >= 0 and clave < nodo.claves[i]: #Recorre de derecha a izquierda buscando donde insertar la nueva clave
                nodo.claves[i + 1] = nodo.claves[i]  #Mueve los elementos a la derecha para hacer hueco para la clave
                i -= 1
            nodo.claves[i + 1] = clave   #Inserta la clave
        else:
            while i >= 0 and clave < nodo.claves[i]: #Busca el hijo mas apropiado para insertar la clave
                i -= 1
            i += 1
            if len(nodo.hijos[i].claves) == ((2 * self.t) - 1): #Si el hijo ya esta lleno, lo divide
                self.dividir(nodo, i)
                if clave > nodo.claves[i]:
                    i += 1
            self.insercion_ordenada(nodo.hijos[i], clave)
    
    '''
    Divide un nodo en dos: la parte izquierda contendra el numero minimo de claves de acuerdo al grado del arbol;
    la parte derecha contendra el resto de elementos menos la mediana
    '''
    def dividir(self, nodo, i):
        t = self.t
        hijo_izquierdo = nodo.hijos[i]
        hijo_derecho = NodoArbolB(hijo_izquierdo.es_hoja)
        nodo.hijos.insert(i + 1, hijo_derecho)
        nodo.claves.insert(i, hijo_izquierdo.claves[t - 1])
        hijo_derecho.claves = hijo_izquierdo.claves[t:(2 * t) - 1]
        hijo_izquierdo.claves = hijo_izquierdo.claves[0:t - 1]
        if not hijo_izquierdo.es_hoja:
            hijo_derecho.hijos = hijo_izquierdo.hijos[t:(2 * t)]
            hijo_izquierdo.hijos = hijo_izquierdo.hijos[0:t - 1]
    
    '''
    Empieza a buscar la clave desde la raiz hasta abajo. Retorna el nodo donde se encuentra la clave
    '''
    def buscar(self, clave):
        return self.busqueda(self.raiz, clave)

    def busqueda(self, nodo, clave):
        #Primero busca dentro de las claves del nodo
        i = 0
        while i < len(nodo.claves) and clave > nodo.claves[i]:
            i += 1
        #Si el valor se encuentra en el nodo, retorna el nodo
        if i < len(nodo.claves) and clave == nodo.claves[i]:
            print("Valor encontrado con exito")
            return nodo
        #Si el nodo no tiene hijos, el valor no se encuentra en el arbol
        elif nodo.es_hoja:
            print("No se encontro el valor dentro del arbol")
            return None
        else:
            self.busqueda(nodo.hijos[i], clave)

    def imprimir_arbol(self):
        self.raiz.imprimir(self.raiz)
        print("")

    
    '''
    Apartado de eliminacion. Codigo sacado en su totalidad de internet.
    (Nunca se me hubiera ocurrido)
    '''
    
    def eliminar(self, clave):
        self.eliminacion_recursiva(self.raiz, clave)
    '''
    Elimina una clave del arbol. Empieza buscando desde la raiz hasta llegar al nodo y la posicion donde se encuentra.
    Elimina la clave del nodo, y si algun nodo en la estructura termina con menos del minimo de claves (grado/2 -1),
    reestructura todo el arbol de manera recursiva las veces necesarias
    '''
    def eliminacion_recursiva(self, nodo, clave):
        i = 0
        while i < len(nodo.claves) and clave > nodo.claves[i]:
            i += 1

        if i < len(nodo.claves) and clave == nodo.claves[i]:
            if nodo.es_hoja:
                nodo.claves.pop(i)
            else:
                y = nodo.hijos[i]
                z = nodo.hijos[i + 1]
                if len(y.claves) >= self.t:
                    predecesor = self.get_predecesor(y)
                    nodo.claves[i] = predecesor
                    self.eliminacion_recursiva(y, predecesor)
                elif len(z.claves) >= self.t:
                    succesor = self.get_sucesor(z)
                    nodo.claves[i] = succesor
                    self.eliminacion_recursiva(z, succesor)
                else:
                    self.unir_nodos(nodo, i, y, z)
                    self.eliminacion_recursiva(y, clave)
        else:
            if nodo.es_hoja:
                print(f"La clave {clave} no existe en el Arbol.")
            else:
                if len(nodo.hijos[i].claves) < self.t:
                    self.ajustar_hijo(nodo, i)

                self.eliminacion_recursiva(nodo.hijos[i], clave)
    
    def unir_nodos(self, x, i, y, z):
        y.claves.append(x.claves[i])
        y.claves.extend(z.claves)
        y.hijos.extend(z.hijos)
        x.claves.pop(i)
        x.hijos.pop(i + 1)

        if len(x.claves) == 0:  
            self.raiz = y

    def get_predecesor(self, x):
        while not x.es_hoja:
            x = x.hijos[-1]
        return x.claves[-1]

    def get_sucesor(self, x):
        while not x.es_hoja:
            x = x.hijos[0]
        return x.claves[0]
    
    def ajustar_hijo(self, x, i):
        if i > 0 and len(x.hijos[i - 1].claves) >= self.t:
            self.tomar_desde_derecha(x, i)
        elif i < len(x.hijos) - 1 and len(x.hijos[i + 1].claves) >= self.t:
            self.tomar_desde_izquierda(x, i)
        else:
            if i > 0:
                self.unir_nodos(x, i - 1, x.hijos[i - 1], x.hijos[i])
                i -= 1
            else:
                self.unir_nodos(x, i, x.hijos[i], x.hijos[i + 1])
    
    def tomar_desde_derecha(self, x, i):
        hijo = x.hijos[i]
        hermano = x.hijos[i - 1]

        hijo.claves.insert(0, x.claves[i - 1])
        x.claves[i - 1] = hermano.claves.pop()
        if not hijo.es_hoja:
            hijo.hijos.insert(0, hermano.hijos.pop())

    def tomar_desde_izquierda(self, x, i):
        hijo = x.hijos[i]
        hermano = x.hijos[i + 1]

        hijo.claves.append(x.claves[i])
        x.claves[i] = hermano.claves.pop(0)
        if not hijo.es_hoja:
            hijo.hijos.append(hermano.hijos.pop(0))
import random
#Retorna el indice en el que se encuentra el elemento a buscar
def busquedaBinaria(array, numero):
    inicio = 0
    fin = len(array) - 1
    while inicio <= fin:
        centro = (inicio + fin) // 2
        actual = array[centro]
        if actual == numero:
            return centro
        elif actual > numero:
            fin = centro -1
        else:
            inicio = centro + 1
    return None

def generarLista(tamano):
    lista = []
    anterior = 0
    for i in range (0,tamano):
        lista.append(random.randint(1,5) + anterior)
        anterior = lista[i]
    return lista


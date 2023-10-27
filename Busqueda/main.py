from BusquedaBinaria import busquedaBinaria, generarLista
import random

#Generar la lista
lista = generarLista(1000)
print("LISTA",lista, sep = "\n")

#Numero a buscar
numero = random.randint(0,5000)
print("El numero a buscar es:", numero)

#Resultado final
indice = busquedaBinaria(lista, numero)
if indice != None:
    print("El numero se encuentra en la posicion:", indice)
else:
    print("El numero no se encentra en la lista")
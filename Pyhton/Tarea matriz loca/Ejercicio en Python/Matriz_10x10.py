import sys
import time


def matrizloca():
    archivo = open("Matriz_100x100.txt", "r")
    anchAlt = archivo.readline().split()
    alto = int(anchAlt[0])
    ancho = int(anchAlt[1])
    matriz = []
    pos = 0
    while alto > 0:
        numeros = archivo.readline().split()
        matriz.append([])
        for i in range(len(numeros)):
            matriz[pos].append(int(numeros[i]))
            if pos == 0 or pos % 2 == 0:
                matriz[pos][i] += 1
            if i == 0 or i % 2 == 0:
                matriz[pos][i] += 2
            if pos % 2 != 0 and i % 2 != 0:
                matriz[pos][i] -= 3
        pos += 1
        alto -= 1
    for i in range(pos):
        for j in range(ancho):
            if ancho - 1 == j:
                print(" ", end=" ")
            else:
                print(" ", end=" ")

def main():
    for i in range(20):
        start_time = time.time()

        matrizloca()

        end_time = time.time()
        elapsed_time_ns = end_time - start_time
        print(f"\nT0,{elapsed_time_ns}B")


sys.exit(main())

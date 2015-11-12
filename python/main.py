# Integrantes: Manolo Capilla y Sergio de leon
import networkx as nx
# En primer lugar debemos de abrir el fichero que vamos a leer.
# Usa 'rb' en vez de 'r' si se trata de un fichero binario.
infile = open('guategrafo.txt', 'r')
# Mostramos por pantalla lo que leemos desde el fichero
print('>>> Lectura del fichero línea a línea')
ciudades=[]
for line in infile:
    dividir = line.split()
    ciudades.append(dividir)
# Cerramos el fic

# ejemplo. Encontrar ruta mas corta
# con algoritmo de Floyd

g = nx.DiGraph()
contador = 0
while contador < len(ciudades):
    g.add_edge(ciudades[contador][0],ciudades[contador][1],weight=int(ciudades[contador][2]))
    contador=contador+1

def programa():
    Inicio = raw_input("Ingrese la ciudad de partida: ")
    Final = raw_input("Ingrese la ciudad de llegada: ")
    FinalAlt = Final
    predecesor, distance = nx.floyd_warshall_predecessor_and_distance(g)
    distancias = predecesor[Inicio].keys()

    n=0
    recorrido = []
    recorrido.append(Final)
    while n < len(distancias) :
            if distancias[n] == FinalAlt:
                recorrido.append(predecesor[Inicio][distancias[n]])
                if predecesor[Inicio][distancias[n]] != Inicio:
                    FinalAlt = predecesor[Inicio][distancias[n]]
                    n=-1
            n=n+1
    print
    print "Disancia: "
    print distance[Inicio][Final]
    print "Camino mas corto:"
    n = len(recorrido) - 1
    while n >= 0:
        print recorrido[n]
        n=n-1
    print "CENTRO DEL GRAFO"
    print
    print FinalAlt
programa()
print "MODIICACIONES"
while True:
    print " a)hay interrupción de tráfico entre un par de ciudades o"    
    a=raw_input(" b) se establece una conexión entre ciudad1 y ciudad2 con valor de x KM de distancia") 
    if a == "a":
        ciudad1=raw_input("Ingrese ciudad1: ")
        ciudad2=raw_input("Ingrese ciudad2: ")
        g.remove_edge(ciudad1,ciudad2)
        break
    if a == "b":
        ciudad1=raw_input("Ingrese ciudad1: ")
        ciudad2=raw_input("Ingrese ciudad2: ")
        peso= raw_input("Ingrese peso: ")
        g.add_edge(ciudad1,ciudad2,weight=int(peso))
        break
   
programa()


#Bubble Sort
def bubble_sort(lista): 
    for i in range(len(lista)): #per ogni elemento della lista
        for j in range(len(lista)-1): #per ogni elemento della lista fino alla penultima posizione
            if lista[j] > lista[j+1]: #se l'elemento attuale è maggiore del successivo
                lista[j], lista[j+1] = lista[j+1], lista[j] #scambio degli elementi
    return lista

a = [1,2,0,9,8,10,7,6,5,4,3]
print(bubble_sort(a))

'''
Non lo ha spiegato ma vabhe
Tempo caso migliore: alpha(n)
Tempo caso peggiore: O(n^2)
Tempo medio: O(n^2)
'''
def selection_sort(lista):
    for i in range(len(lista)): #per ogni elemento della lista
        min = i #salvo la posizione dell'elemento minimo
        for j in range(i+1, len(lista)): #per ogni elemento della lista successivo all'elemento attuale
            if lista[j] < lista[min]: #se l'elemento attuale è minore del minimo
                min = j #salvo la posizione dell'elemento minimo
        lista[i], lista[min] = lista[min], lista[i] #scambio degli elementi
    return lista

a = [1,2,0,9,8,10,7,6,5,4,3]
print(selection_sort(a))

'''
Tempo caso migliore: alpha(n^2)
Tempo caso peggiore: O(n^2)
Tempo medio: O(n^2)
'''
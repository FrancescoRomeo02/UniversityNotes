from curses import A_ALTCHARSET
from re import A


def insertion_sort(A):
    for i in range(1, len(A)): #per ogni elemento della lista
        key = A[i] #salvo l'elemento attuale
        j = i - 1 #salvo la posizione dell'elemento precedente
        while j >= 0 and key < A[j]: #finchè la posizione dell'elemento precedente è maggiore di 0 e l'elemento attuale è minore del precedente
            A[j + 1] = A[j] #scambio degli elementi
            j -= 1 #decremento della posizione dell'elemento precedente
        A[j + 1] = key #inserisco l'elemento attuale nella posizione giusta
    return A

a = [1,2,0,9,8,10,7,6,5,4,3]
print(insertion_sort(a))


'''
Tempo caso migliore: alpha(n)
Tempo caso peggiore: O(n^2)
Tempo medio: O(n^2)
'''
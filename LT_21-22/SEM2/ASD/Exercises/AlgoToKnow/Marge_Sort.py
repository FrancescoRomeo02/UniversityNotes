#margesort
def margeSort(A,p,r):
    if p<r: #se la lunghezza del vettore è maggiore di 1
        q=(p+r)//2 #calcolo della posizione media del vettore
        margeSort(A,p,q) #ordinamento del primo sotto-vettore
        margeSort(A,q+1,r) #ordinamento del secondo sotto-vettore
        marge(A,p,q,r) #combinazione del risultato

def marge(A,p,q,r):
    L=A[p:q+1] #creazione del primo sotto-vettore
    R=A[q+1:r+1] #creazione del secondo sotto-vettore
    i=0 #indice del primo sotto-vettore
    j=0 #indice del secondo sotto-vettore
    k=p #indice del vettore originale
    while i<len(L) and j<len(R): #finchè i e j non sono arrivati alla fine dei due sotto-vettori
        if L[i]<R[j]: #se il primo elemento del primo sotto-vettore è minore del secondo
            A[k]=L[i] #il primo elemento del primo sotto-vettore viene inserito nel vettore originale
            i+=1 #incremento dell'indice del primo sotto-vettore
        else: 
            A[k]=R[j] #altrimenti il primo elemento del secondo sotto-vettore viene inserito nel vettore originale
            j+=1 #incremento dell'indice del secondo sotto-vettore
        k+=1 #incremento dell'indice del vettore originale
    while i<len(L): #finchè i non è arrivato alla fine del primo sotto-vettore
        A[k]=L[i] #il primo elemento del primo sotto-vettore viene inserito nel vettore originale
        i+=1 #incremento dell'indice del primo sotto-vettore
        k+=1 #incremento dell'indice del vettore originale
    while j<len(R): #finchè j non è arrivato alla fine del secondo sotto-vettore
        A[k]=R[j] #il primo elemento del secondo sotto-vettore viene inserito nel vettore originale
        j+=1 #incremento dell'indice del secondo sotto-vettore
        k+=1 #incremento dell'indice del vettore originale
    #uno dei due sotto-vettori è già stato scorso e quindi non è necessario effettuare nessuna operazione.
    
a = [1,2,0,9,8,10,7,6,5,4,3]
margeSort(a,0,len(a)-1)
print(a)

'''
anche se non serve saperlo
Tempo caso migliore: O(nlogn)
Tempo caso peggiore: O(nlogn)
Tempo medio: O(nlogn)
'''
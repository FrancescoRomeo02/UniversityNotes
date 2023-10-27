def trova_occorrenze(a, k, i,f):
    if(i>=f):
        return 0  
    else:
        m = (i+f)//2
        contai = trova_occorrenze(a, k, i,m)
        contaf = trova_occorrenze(a, k, m+1,f)
        conta = contaf + contai
        if(a[m]==a[m+1]==k):
            conta=conta+1
    return conta


a = [3,3,3,3,4,5,6,1,2,3,3,3,4,5,6,2,2,1,2,2,1,1,3,3,3]
print(trova_occorrenze(a,3,0,len(a)-1))

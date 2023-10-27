def sequenza(a,k1,k2,i,f):
    if(i>=f):
        return 0
    elif(i==f-1):
        if((a[i]==k1 and a[f]==k2) or (a[i]==k2 and a[f]==k1)):
            return 1
        else:
            return 0 
    else:
        m=(i+f)//2
        t1 = sequenza(a,k1,k2,i,m)
        t2 = sequenza(a,k1,k2,m+1,f)
        t = t1 + t2
        if((a[m]==k1 and a[m+1]==k2) or (a[m]==k2 and a[m+1]==k1)):
            t = t+1        
    return t 

a = ['a','b','a','b','a','b']
print(sequenza(a,'a','b',0,len(a)-1))
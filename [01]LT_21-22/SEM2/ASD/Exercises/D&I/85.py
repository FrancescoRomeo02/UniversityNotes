def funzione(a,i,f):
    if(f<=i):
        return 0
    elif(i==f-1):
        if(a[i]==8 and a[f]==5):
            return True
        else:
            return False
    else:
        m = (i+f)//2
        rl = funzione(a,i,m)
        rr = funzione(a,m,f)
        if(not rl and rr or rl and not rr):
            return True
        else:
            return False

a = [8,5,8,4,8,5]
print(funzione(a,0,len(a)-1))
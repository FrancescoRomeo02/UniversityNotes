def calcolatore(a,i,f):
    if(f<=i):
        return -1
    elif(i==f-1):
        return a[i]*a[f]
    else:
        m = (i+f)//2
        rl = calcolatore(a,i,m)
        rr = calcolatore(a,m,f)
        rt = rl+rr
    return rt

a = [1,2,4,5,6]
print(calcolatore(a,0,len(a)-1))

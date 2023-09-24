def r_shift(a,i,f):
    if(f<i):
        return 0
    elif(i==f):
        return a
    elif(i==f-1):
        a[f]=a[i]
        a[i]=a[len(a)-1-i]
    else:
        m=(i+f)//2
        r_shift(a,i,m)
        r_shift(a,m+1,f)

    return a
    
a = [8, 3, 10, 7]
print("input:\t", a)
r_shift(a, 0, len(a)-1)
print("output:\t",a)
print("aspettativa:\t" ,[7, 8, 3, 10])
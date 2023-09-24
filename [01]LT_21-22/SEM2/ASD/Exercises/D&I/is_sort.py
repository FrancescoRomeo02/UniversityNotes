def is_sort(a,i,f):
    if(f<i):
        return False
    elif(i==f):
        return True
    elif(i==f-1):
        print(f"controllo su {a[i]} e {a[f]}")
        return(a[i]<a[f])
    else:
        m = (i+f)//2
        temp_l = is_sort(a,i,m)
        temp_r = is_sort(a,m,f)
        r = temp_l*temp_r
    return r

a = [3,4,9,10,17]
print(is_sort(a,0,len(a)-1))


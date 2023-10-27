def vocale(c):
    if c in ('a', 'e', 'i', 'o', 'u'):
        return True
    else:
        return False

def vocalipari(a,i,f):
    if(i>f):
        return -1
    elif(i==f):
        return not vocale(a[i])
    else:
        m = (i+f)//2
        r1 = vocalipari(a,i,m)
        r2 = vocalipari(a,m+1,f)
        if(not r1 and r2 or not r2 and r1):
            return not vocale(a[m])
        else:
            return vocale(a[m])


a = ['a', 'a', 'a', 'a']

print(vocalipari(a, 0, len(a)-1))


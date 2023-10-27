def count_TT(a, left, right):
    if(left >= right):
        return 0
    else:
        m = (left+right)//2
        count_l = count_TT(a, left, m)
        count_r = count_TT(a, m+1, right)
        count_t = count_l+count_r
        if(a[m] and a[m+1]):
            count_t+=1
        return count_t

a = [True, True, True, True, True, False]
print(count_TT(a,0,len(a)-1))
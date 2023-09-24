def count_1001(a, left, right):
    if left >= right:
        return 0
    else:
        m = (left+right)//4
        count_1 = count_1001(a, left, m)
        count_2 = count_1001(a, m+1, 2*m)
        count_3 = count_1001(a, 2*m+1, 3*m)
        count_4 = count_1001(a, 3*m+1, right)
        count_t = count_1 + count_2 + count_3 + count_4
        if(a[m]==1 and a[m+1]==0 and a[m+2]==0 and a[m+3]==1):
            count_t+=1
    return count_t

a = [1,0,0,1,0]
print(count_1001(a, 0, len(a)-1))
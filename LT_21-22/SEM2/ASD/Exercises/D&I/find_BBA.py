def find_BBA(a, left, right):
    if(left >= right):
        return 0
    else:
        m = (left+right)//3
        count_1 = find_BBA(a, left, m)
        count_2 = find_BBA(a, m+1, 2*m)
        count_3 = find_BBA(a, 2*m+1, right)
        count = count_1 + count_2 + count_3
        if(a[m]=='B' and a[m+1]=='B' and a[m+2]=='A'):
            count = count+1
        return count
a = ['B', 'A', 'A']
print(find_BBA(a, 0, len(a)-1))
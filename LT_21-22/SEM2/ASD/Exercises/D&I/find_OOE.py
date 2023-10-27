def is_odd(n):
    return n%2!=0; 

def find_OOE(a, left, right):
    if(left >= right):
        return 0
    else:
        m = (left+right)//3
        count_1 = find_OOE(a, left, m)
        count_2 = find_OOE(a, m+1, m+m)
        count_3 = find_OOE(a, m+m+1, right)
        count = count_1 + count_2 + count_3
        if(is_odd(a[m]) and is_odd(a[m+1]) and not is_odd(a[m+2])):
            count = count+1
        return count
a = [3, 3, 32]
print(find_OOE(a, 0, len(a)-1))


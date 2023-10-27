def count_1_0 (a, left, right,segnale):
    if(left>=right):
        return(0)
    else:
        print(f'Inizio vale:{left}, fine vale:{right}, chiamato da: {segnale}')
        m = (left+right)//2
        conta_l=count_1_0(a, left, m, "left")
        print(f'conta_l vale:{conta_l}')
        conta_r = count_1_0(a, m+1, right, "right")
        print(f'conta_r vale:{conta_r}')
        conta_t = conta_l + conta_r
        if(a[m]==1 and a[m+1]==0):
            conta_t=conta_t+1
    return conta_t

a = [1,0,1,1,0]
print(count_1_0(a, 0, (len(a)-1), "main"))
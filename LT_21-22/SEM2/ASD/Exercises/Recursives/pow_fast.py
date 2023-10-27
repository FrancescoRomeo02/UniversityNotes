def pow_fast(a,b):
    if b == 0:
        return 1
    elif b % 2 == 0:
        return pow_fast(a, b/2) * pow_fast(a, b/2)
    else:
        pow_fast(a,b/2) * pow_fast(a,b/2) * a
#
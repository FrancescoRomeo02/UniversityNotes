def from_decimal_conv(n, b):
    if n < 10:
        return 1
    else:
        print(n%b, end="")
        return from_decimal_conv(n/2,b)
        

print(from_decimal_conv(5, 2))


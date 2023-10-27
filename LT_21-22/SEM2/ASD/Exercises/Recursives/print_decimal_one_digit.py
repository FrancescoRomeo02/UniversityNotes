def print_decimal_one_digit(n):
    if n == 0:
        pass
    else:
        print_decimal_one_digit(n // 10)
        print(n % 10, end="")

print_decimal_one_digit(293)
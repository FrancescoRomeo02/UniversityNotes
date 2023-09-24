def digit_count(n):
    count = 0
    if n <10:
        return 1 
    else:
        count = 1 + digit_count(n//10)
        return count

print(digit_count(100))


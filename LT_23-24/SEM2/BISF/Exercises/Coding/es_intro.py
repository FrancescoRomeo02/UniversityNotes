import numpy as np

def my_func(x):
    return(sum(x), min(x), max(x), np.average(x), np.std(x))

np.random.seed(1)

v1 = np.random.choice(np.arange(1,5), size=10)
print(v1)

pv1 = 1

for i in v1:
    pv1 *= i

print(pv1)

print(np.prod(v1))
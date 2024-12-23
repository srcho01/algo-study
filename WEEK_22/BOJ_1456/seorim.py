import sys
from math import sqrt

a, b = map(int, sys.stdin.readline().split())
prime_max = int(sqrt(b)) + 1
prime = [True] * (prime_max+1)
prime[0] = prime[1] = False

for i in range(2, prime_max+1):
    if prime[i]:
        for j in range(i*i, prime_max+1, i):
            prime[j] = False

cnt = 0
for p in range(2, prime_max+1):
    if prime[p]:
        n = 2
        while True:
            power = p ** n
            if a <= power and power <= b:
                cnt += 1
            elif power > b:
                break
            n += 1
            
print(cnt)
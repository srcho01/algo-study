import sys

input = sys.stdin.readline

MAX = 1299710

primes = [True] * MAX
primes[0] = primes[1] = False

for i in range(2, MAX):
    if primes[i]:
        for j in range(i*i, MAX, i):
            primes[j] = False
            
t = int(input())
for _ in range(t):
    k = int(input())
    if primes[k]:
        print(0)
        continue
    
    start = end = 0
    for i in range(k-1, 0, -1):
        if primes[i]:
            start = i
            break

    for i in range(k+1, MAX):
        if primes[i]:
            end = i
            break
    
    print(end - start)
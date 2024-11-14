import sys

MAX = 1_000_000
prime = [True] * (MAX + 1)
for i in range(2, MAX + 1):
    if prime[i]:
        for j in range(2*i, MAX+1, i):
            prime[j] = False
            
while True:
    n = int(sys.stdin.readline())
    if n == 0: break
    
    for i in range(3, n//2+1, 2):
        if prime[i] and prime[n-i]:
            print(f"{n} = {i} + {n-i}")
            break
    else:
        print("Goldbach's conjecture is wrong.")
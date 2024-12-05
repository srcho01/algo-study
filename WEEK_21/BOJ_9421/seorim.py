import sys

def sanggeun(k):
    visited = set()
    k = str(k)
    
    while True:
        sqr_sum = 0
        
        for i in k:
            sqr_sum += int(i) ** 2
        
        if sqr_sum == 1:
            return True
        
        if sqr_sum in visited:
            return False
        
        visited.add(sqr_sum)
        k = str(sqr_sum)

n = int(sys.stdin.readline())

prime = [True] * (n+1)
prime[1] = False
ans = []

for i in range(2, n+1):
    if prime[i]:
        for j in range(i * i, n+1, i):
            prime[j] = False
            
        if sanggeun(i):
            ans.append(i)
            
print("\n".join(map(str, ans)))
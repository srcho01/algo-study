import heapq
import sys

input = sys.stdin.readline

k, n = map(int, input().split())
prime = list(map(int, input().split()))
pq = prime.copy()


ans = -1
for _ in range(1, n+1):
    ans = heapq.heappop(pq)
    for p in prime:
        heapq.heappush(pq, ans * p)
        if ans % p == 0: break
        
print(ans)
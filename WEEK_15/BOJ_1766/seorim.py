import sys
from queue import PriorityQueue

input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
indegree = [0] * (n+1)
for _ in range(m):
    a, b = map(int, input().split())
    indegree[b] += 1
    graph[a].append(b)

pq = PriorityQueue()
for i in range(1, n+1):
    if indegree[i] == 0:
        pq.put(i)

seq = []        
for _ in range(n):
    curr = pq.get()
    seq.append(curr)
    
    for next in graph[curr]:
        indegree[next] -= 1
        if indegree[next] == 0:
            pq.put(next)
            
print(" ".join(map(str, seq)))
import sys
from queue import PriorityQueue
from math import inf

input = sys.stdin.readline

n, m, f, s, t = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v, c = map(int, input().split())
    graph[u].append((v, c))
    graph[v].append((u, c))

def dijkstra(start, end):
    pq = PriorityQueue()
    pq.put((0, start))
    visited = [False] * (n+1)
    dist = [inf] * (n+1)
    dist[start] = 0

    while not pq.empty():
        cost, curr = pq.get()
        
        if visited[curr]: continue
        visited[curr] = True
        
        for nxt, w in graph[curr]:
            if not visited[nxt]:
                dist[nxt] = min(dist[nxt], cost + w)
                pq.put((dist[nxt], nxt))
    
    return dist[end]

ans = dijkstra(s, t)
for _ in range(f):
    u, v = map(int, input().split())
    ans = min(ans, dijkstra(s, u) + dijkstra(v, t))
    
print(ans)
import sys
from math import inf

input = sys.stdin.readline

v, e = map(int, input().split())

graph = [[inf] * (v+1) for _ in range(v+1)]
for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for a in range(1, v+1):
    for b in range(1, v+1):
        for k in range(1, v+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
            
ans = inf
for i in range(1, v+1):
    ans = min(ans, graph[i][i])
    
print(ans if ans != inf else -1)
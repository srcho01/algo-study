import sys
from math import inf

input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[inf] * (n+1) for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1

for i in range(1, n+1):
    graph[i][i] = 0

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
            
result = 0
mini = inf
for i in range(1, n+1):
    s = sum(graph[i][1:])
    if  s < mini:
        result = i
        mini = s
        
print(result)
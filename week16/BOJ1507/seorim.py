import sys
from math import inf

input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[True] * n for _ in range(n)]

for k in range(n):
    for a in range(n):
        for b in range(n):
            if a == k or k == b: continue
            
            if graph[a][k] + graph[k][b] < graph[a][b]:
                print(-1)
                exit()
            elif graph[a][k] + graph[k][b] == graph[a][b]:
                visited[a][b] = False

total = 0
for i in range(n):
    for j in range(i+1, n):
        if visited[i][j]:
            total += graph[i][j]

print(total)
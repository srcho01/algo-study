import sys
from collections import deque
from math import inf

input = sys.stdin.readline

n, m = map(int, input().split())

graph = [list(map(int, list(input().strip()))) for _ in range(n)]
dist = [[[inf, inf] for _ in range(m)] for _ in range(n)]
queue = deque() # x, y, 벽
direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]

queue.append((0, 0, 0))
dist[0][0][0] = 1

while queue:
    x, y, used = queue.popleft()
    d = dist[x][y][used]
    
    if x == n-1 and y == m-1:
        print(d)
        break
    
    for dx, dy in direction:
        nx = x + dx
        ny = y + dy
        
        if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
        
        if graph[nx][ny] == 0 and d + 1 < dist[nx][ny][used]:
            queue.append((nx, ny, used))
            dist[nx][ny][used] = d + 1
        
        if used == 0 and graph[nx][ny] == 1 and d + 1 < dist[nx][ny][1]:
            queue.append((nx, ny, 1))
            dist[nx][ny][1] = d + 1
else:
    print(-1)
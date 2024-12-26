import sys
from collections import deque

input = sys.stdin.readline

m, n = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]
direction = [(0, -1), (0, 1), (1, 0), (-1, 0)]

queue = deque()
total = m * n
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append((i, j, 0))
        if box[i][j] != 0:
            total -= 1

day = 0
while queue:
    x, y, day = queue.popleft()
    
    for dx, dy in direction:
        nx, ny = x + dx, y + dy
        if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
        
        if box[nx][ny] == 0:
            queue.append((nx, ny, day+1))
            box[nx][ny] = 1
            total -= 1
    
print(day if total == 0 else -1)
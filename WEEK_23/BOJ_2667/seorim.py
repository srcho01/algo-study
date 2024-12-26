import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
town = [list(input().rstrip()) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
direction = [(0, -1), (0, 1), (1, 0), (-1, 0)]

def bfs(i, j):
    global n
    
    queue = deque([(i, j)])
    visited[i][j] = True
    
    cnt = 0
    while queue:
        x, y = queue.popleft()
        cnt += 1
        
        for dx, dy in direction:
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= n or ny < 0 or ny >= n: continue
            
            if not visited[nx][ny] and town[nx][ny] == '1':
                queue.append((nx, ny))
                visited[nx][ny] = True
    
    return cnt

ans = []             
for i in range(n):
    for j in range(n):
        if not visited[i][j] and town[i][j] == '1':
            ans.append(bfs(i, j))

ans.sort()
print(len(ans))
print("\n".join(map(str, ans)))
import sys
import heapq
from math import inf

input = sys.stdin.readline

m, n = map(int, input().split())
maze = [list(map(int, list(input().rstrip()))) for _ in range(n)]

heap = []
heap.append((0, 0, 0))  # 부순 벽 개수, x, y

visited = [[inf] * (m) for _ in range(n)]
visited[0][0] = 0

dirt = [(0, -1), (0, 1), (1, 0), (-1, 0)]

while heap:
    cnt, x, y = heapq.heappop(heap)
    
    if x == n-1 and y == m-1:
        print(cnt)
        break
    
    for dx, dy in dirt:
        nx = x + dx
        ny = y + dy
        
        if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
        
        if maze[nx][ny] == 1 and cnt + 1 < visited[nx][ny]:
            heapq.heappush(heap, (cnt + 1, nx, ny))
            visited[nx][ny] = cnt + 1
        elif maze[nx][ny] == 0 and cnt < visited[nx][ny]:
            heapq.heappush(heap, (cnt, nx, ny))
            visited[nx][ny] = cnt
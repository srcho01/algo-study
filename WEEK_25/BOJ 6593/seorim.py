import sys
from collections import deque

input = sys.stdin.readline

direction = [(1, 0, 0), (-1, 0, 0), (0, 0, 1), (0, 0, -1), (0, 1, 0), (0, -1, 0)]

while True:
    l, r, c = map(int, input().split())
    if l == 0 and r == 0 and c == 0: break
    
    graph = []
    queue = deque()
    visited = [[[False] * c for _ in range(r)] for _ in range(l)]
    
    for x in range(l):
        layer = []
        for y in range(r):
            line = list(input().rstrip())
            for z in range(c):
                if line[z] == 'S':
                    queue.append((x, y, z, 0))
                    visited[x][y][z] = True
            layer.append(line)
        
        graph.append(layer)
        _ = input()
    
    while queue:
        x, y, z, time = queue.popleft()
        
        if graph[x][y][z] == 'E':
            print(f"Escaped in {time} minute(s).")
            break
            
        for dx, dy, dz in direction:
            nx, ny, nz = x + dx, y + dy, z + dz
            if nx < 0 or nx >= l or ny < 0 or ny >= r or nz < 0 or nz >= c:
                continue
            
            if not visited[nx][ny][nz] and not graph[nx][ny][nz] == '#':
                queue.append((nx, ny, nz, time+1))
                visited[nx][ny][nz] = True
    else:
        print("Trapped!")
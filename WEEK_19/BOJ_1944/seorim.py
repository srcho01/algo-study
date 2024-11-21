import sys
from collections import deque

class UnionFind:
    parent = []
    
    def __init__(self, size):
        for i in range(size+1):
            self.parent.append(i)
    
    def find(self, x):
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
            
        return x
            
    def union(self, u, v):
        u_root = self.find(u)
        v_root = self.find(v)
        
        if u_root == v_root:
            return False
        
        if u_root < v_root:
            self.parent[v_root] = u_root
        else:
            self.parent[u_root] = v_root
            
        return True

input = sys.stdin.readline
n, m = map(int, input().split())
maze = []
node = []
edges = []
direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]    

for i in range(n):
    line = list(input().strip())
    maze.append(line)
    for j, c in enumerate(line):
        if c == 'S' or c == 'K':
            node.append((i, j))

def bfs(x1, y1, x2, y2, node1, node2):
    global n
    
    queue = deque()
    visited = [[False] * n for _ in range(n)]
    
    queue.append((x1, y1, 0))
    visited[x1][y1] = True
    
    while queue:
        x, y, cnt = queue.popleft()
        
        if x == x2 and y == y2:
            edges.append((node1, node2, cnt))
            break
            
        for dx, dy in direction:
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= n or ny < 0 or ny >= n or visited[nx][ny]:
                continue
            
            if maze[nx][ny] != '1':
                visited[nx][ny] = True
                queue.append((nx, ny, cnt+1))
    else:
        print(-1)
        exit()
    
                
for i in range(m+1):
    for j in range(i+1, m+1):
        x1, y1 = node[i]
        x2, y2 = node[j]
        bfs(x1, y1, x2, y2, i, j)

edges.sort(key=lambda x: x[2])
uf = UnionFind(m+1)
ans = 0
cnt = 0
for n1, n2, w in edges:
    if uf.union(n1, n2):
        ans += w
        cnt += 1
        if cnt == m: break
        
print(ans)
import sys

input = sys.stdin.readline

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
        
        if u_root < v_root:
            self.parent[v_root] = u_root
        else:
            self.parent[u_root] = v_root
            
    def is_connected(self, u, v):
        return self.find(u) == self.find(v)
    

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(m)]
graph.sort(key=lambda x: x[2])

uf = UnionFind(n)

cnt = 0
total = 0

for u, v, cost in graph:
    if cnt >= n-2: break
    
    if not uf.is_connected(u, v):
        uf.union(u, v)
        cnt += 1
        total += cost
        
print(total)
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
start, end = map(int, input().split())
graph = [tuple(map(int, input().split())) for _ in range(m)]
graph.sort(key=lambda x: -x[2])

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
    
    def is_connected(self, u, v):
        return self.find(u) == self.find(v)
    
uf = UnionFind(n)
for u, v, c in graph:
    if not uf.is_connected(u, v):
        uf.union(u, v)
        if uf.is_connected(start, end):
            print(c)
            break
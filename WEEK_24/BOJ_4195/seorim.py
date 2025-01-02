import sys

input = sys.stdin.readline

class UnionFind:
    parent = 0
    size = 0
    
    def __init__(self):
        self.parent = dict()
        self.size = dict()
    
    def find(self, x):
        if not x in self.parent.keys():
            self.parent[x] = x
            self.size[x] = 1
        
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
            
        return x
            
    def union(self, u, v):
        u_root = self.find(u)
        v_root = self.find(v)
        
        if u_root != v_root:
            self.parent[u_root] = v_root
            new_size = self.size[u_root] + self.size[v_root]
            self.size[u_root] = new_size
            self.size[v_root] = new_size
        
        return self.size[u_root]
            
t = int(input())
for _ in range(t):
    f = int(input())
    
    uf = UnionFind()
    for _ in range(f):
        a, b = map(str, input().rstrip().split())
        print(uf.union(a, b))
import sys

input = sys.stdin.readline


class UnionFind:
    parent = []
    
    def __init__(self, size):
        for i in range(size+1):
            self.parent.append(i)
            
    def find(self, node):
        while node != self.parent[node]:
            self.parent[node] = self.parent[self.parent[node]]
            node = self.parent[node]
            
        return node
    
    def union(self, u, v):
        u_root = self.find(u)
        v_root = self.find(v)
        
        if u_root < v_root:
            self.parent[v_root] = u_root
        else:
            self.parent[u_root] = v_root
            
    def is_connected(self, u, v):
        return self.find(u) == self.find(v)


n = int(input())
m = int(input())  

uf = UnionFind(n)
for i in range(1, n+1):
    line = [0] + list(map(int, input().split()))
    for j in range(1, i):
        if line[j] == 1:
            uf.union(i, j)

trip = list(map(int, input().split()))
for i in range(1, m):
    if not uf.is_connected(trip[i-1], trip[i]):
        print("NO")
        break
else:
    print("YES")
import sys

sys.setrecursionlimit(10**8)
input = sys.stdin.readline

n = int(input())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v, w = map(int, input().split())
    tree[u].append((v, w))
    
dist = [[] for _ in range(n+1)]

ans = 0
def dfs(node):
    global ans
    
    if not tree[node]:
        dist[node].append(0)
        return
    
    for child, weight in tree[node]:
        dfs(child)
        dist[node].append(weight + max(dist[child]))
    
    dist[node] = sorted(dist[node], reverse=True)[:2]
    ans = max(ans, sum(dist[node]))

dfs(1)
print(ans)
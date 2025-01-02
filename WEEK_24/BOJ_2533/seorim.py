import sys
from math import inf

sys.setrecursionlimit(10**8)
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
    
dp = [[0, 1] for _ in range(n+1)]
visited = [False] * (n+1)

def dfs(node):
    visited[node] = True
    
    for child in graph[node]:
        if visited[child]: continue
        
        dfs(child)
        dp[node][0] += dp[child][1]
        dp[node][1] += min(dp[child])
        
dfs(1)
print(min(dp[1]))
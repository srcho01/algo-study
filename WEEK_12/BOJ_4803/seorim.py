import sys

input = sys.stdin.readline


def bfs(graph, visited, x):
    visited[x] = True
    queue = []
    queue.append(x)
    
    while queue:
        curr = queue.pop(0)
        
        for next in graph[curr]:
            if not visited[next]:
                visited[next] = True
                queue.append(next)
                graph[next].remove(curr)
            else:
                return 0
            
    return 1

num = 1
while True:
    n, m = map(int, input().split())
    
    if n == 0 and m == 0: break
    
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
        
    visited = [False] * (n+1)
    cnt = 0
    
    for i in range(1, n+1):
        if not visited[i]:
            cnt += bfs(graph, visited, i)
            
    if cnt == 0:
        print(f"Case {num}: No trees.")
    elif cnt == 1:
        print(f"Case {num}: There is one tree.")
    else:
        print(f"Case {num}: A forest of {cnt} trees.")
    
    num += 1
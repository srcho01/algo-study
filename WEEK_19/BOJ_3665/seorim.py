import sys
from collections import deque

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    last = list(map(int, input().split()))
    
    indegree = [0] * (n+1)
    graph = [[] for _ in range(n+1)]
    for i in range(n):
        graph[last[i]] = last[i+1:]
        indegree[last[i]] = i
    
    m = int(input())
    for _ in range(m):
        a, b = map(int, input().split())
        if b in graph[a]:  # a -> b
            graph[a].remove(b)
            graph[b].append(a)
            indegree[a] += 1
            indegree[b] -= 1
        else:  # b -> a
            graph[a].append(b)
            graph[b].remove(a)
            indegree[a] -= 1
            indegree[b] += 1
            
    queue = deque()
    for node, dg in enumerate(indegree[1:], 1):
        if dg == 0:
            queue.append(node)
            
    ans = []
    while queue:
        if len(queue) > 1:
            print("?")
            break
            
        curr = queue.popleft()
        ans.append(curr)
        
        for nxt in graph[curr]:
            indegree[nxt] -= 1
            if indegree[nxt] == 0:
                queue.append(nxt)
                
    if len(ans) < n:
        print("IMPOSSIBLE")
    else:
        print(*ans)
import sys
from collections import deque

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, k = map(int, input().split())
    time = [0] + list(map(int, input().split()))
    complete_time = [-1] * (n+1)
    
    indegree = [0] * (n+1)
    graph = [[] for _ in range(n+1)]
    for _ in range(k):
        x, y = map(int, input().split())
        indegree[y] += 1
        graph[x].append(y)
        
    w = int(input())
    
    queue = deque()
    
    for i in range(1, n+1):
        if indegree[i] == 0:
            queue.append(i)
            complete_time[i] = time[i]
            
    for _ in range(n):
        curr = queue.popleft()
        
        if curr == w:
            print(complete_time[w])
            break
        
        for next in graph[curr]:
            complete_time[next] = max(complete_time[next], time[next] + complete_time[curr])
            indegree[next] -= 1
            
            if indegree[next] == 0:
                queue.append(next)
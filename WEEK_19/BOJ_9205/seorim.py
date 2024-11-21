import sys
from collections import deque

input = sys.stdin.readline

def dist(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])

t = int(input())
for _ in range(t):
    n = int(input())
    home = tuple(map(int, input().split()))
    convenience = [tuple(map(int, input().split())) for _ in range(n)]
    dest = tuple(map(int, input().split()))
    
    visited = [False] * n
    queue = deque([home])
    
    while queue:
        curr = queue.popleft()
        
        if dist(curr, dest) <= 1000:
            print("happy")
            break
        
        for i, nxt in enumerate(convenience):
            if dist(curr, nxt) <= 1000 and not visited[i]:
                queue.append(nxt)
                visited[i] = True
    else:
        print("sad")
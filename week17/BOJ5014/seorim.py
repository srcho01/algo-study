import sys
from collections import deque

input = sys.stdin.readline

f, s, g, u, d = map(int, input().split())
q = deque([(s, 0)])
visited = [False] * (f+1)
visited[s] = True

while q:
    curr, cnt = q.popleft()
    
    if curr == g:
        print(cnt)
        break
    
    for dx in [u, -d]:
        nxt = curr + dx
        if (1 <= nxt and nxt <= f) and not visited[nxt]:
            visited[nxt] = True
            q.append((nxt, cnt+1))
else:
    print("use the stairs")
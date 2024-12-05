import sys
from collections import deque

input = sys.stdin.readline

def make_b(n):
    if n * 2 > 99999:
        return -1
    
    ret = str(n * 2)
    if ret[0] == '1':
        return int(ret[1:])
    else:
        first = str(int(ret[0]) - 1)
        return int(first + ret[1:])

n, t, g = map(int, input().split())
queue = deque([(n, 0)])
visited = set()
visited.add(-1)

while queue:
    curr, cnt = queue.popleft()
    
    if curr == g:
        print(cnt)
        break
    
    a = curr + 1 if curr + 1 <= 99999 else -1
    b = make_b(curr)
    
    for nxt in [a, b]:
        if not nxt in visited and cnt < t:
            visited.add(nxt)
            queue.append((nxt, cnt+1))
else:
    print("ANG")
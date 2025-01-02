import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())
seq = "".join(list(map(str, input().rstrip().split())))

def is_ascending(n, li):
    for i in range(1, n):
        if li[i-1] > li[i]:
            return False

    return True

queue = deque([(seq, 0)])
visited = set()
visited.add(seq)

while queue:
    li, cnt = queue.popleft()
    
    if is_ascending(n, li):
        print(cnt)
        break
    
    for i in range(n-k+1):
        next_sort = li[:i] + li[i:i+k][::-1] + li[i+k:]
        if not next_sort in visited:
            visited.add(next_sort)
            queue.append((next_sort, cnt+1))
else:
    print(-1)
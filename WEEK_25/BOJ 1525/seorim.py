import sys
from collections import deque

input = sys.stdin.readline

d = [(1, 3), (0, 2, 4), (1, 5), (0, 4, 6), (1, 3, 5, 7), (2, 4, 8), (3, 7), (4, 6, 8), (5, 7)]

def swap(li, a, b):
    li[a], li[b] = li[b], li[a]

data = ""
for _ in range(3):
    data += "".join(list(map(str, input().split())))

queue = deque([(data, 0)])
visited = set()
visited.add(data)
while queue:
    status, cnt = queue.popleft()
    
    if status == "123456780":
        print(cnt)
        break
    
    idx = -1
    for i in range(9):
        if status[i] == "0":
            idx = i
            break
    
    status = list(status)
    for nxt in d[idx]:
        swap(status, idx, nxt)
        next_status = "".join(status)
        
        if not next_status in visited:
            queue.append((next_status, cnt+1))
            visited.add(next_status)
        
        swap(status, idx, nxt)
        
else:
    print(-1)
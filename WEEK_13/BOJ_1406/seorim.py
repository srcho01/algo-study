import sys
from collections import deque

input = sys.stdin.readline


before = deque(list(input().rstrip()))
after = deque()

n = int(input())

for _ in range(n):
    data = input().rstrip()
    cmd = data[0]
    
    match cmd:
        case 'L':
            if len(before) > 0:
                after.appendleft(before.pop())
        case 'D':
            if len(after) > 0:
                before.append(after.popleft())
        case 'B':
            if len(before) > 0:
                before.pop()
        case 'P':
            before.append(data[2])
            
print("".join(map(str, before)) + "".join(map(str, after)))
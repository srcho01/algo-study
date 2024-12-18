import sys

input = sys.stdin.readline

n = int(input())
data = [tuple(map(int, input().split())) for _ in range(n)]
data.sort(key=lambda x: (x[1], x[0]))

cnt = 0
prev_end = -1
for start, end in data:
    if start >= prev_end:
        cnt += 1
        prev_end = end
        
print(cnt)
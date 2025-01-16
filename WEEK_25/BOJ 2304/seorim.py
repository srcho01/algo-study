import sys

input = sys.stdin.readline

n = int(input())
storage = [list(map(int, input().split())) for _ in range(n)]
storage.sort(key=lambda x: x[0])

highest = -1
mx = -1
for i, pillar in enumerate(storage):
    if pillar[1] > mx:
        highest = i
        mx = pillar[1]

ans = storage[highest][1]
height = storage[0][1]
for i in range(1, highest+1):
    x, h = storage[i]
    ans += (x - storage[i-1][0]) * height
    
    if height < h:
        height = h

height = storage[n-1][1]        
for i in range(n-2, highest-1, -1):
    x, h = storage[i]
    log = (storage[i+1][0] - x) * height
    ans += (storage[i+1][0] - x) * height
    
    if height < h:
        height = h
        
print(ans)
import sys
import math

x, y = map(int, sys.stdin.readline().split())
n = y - x + 1
arr = [True] * n

for i in range(2, int(math.sqrt(y)+1)):
    sqr = i*i
    if sqr-x >= 0 and not arr[sqr-x]:
        continue
    
    start = (x + sqr - 1) // sqr * sqr
    for j in range(start, y+1, sqr):
        arr[j-x] = False

print(sum(arr))
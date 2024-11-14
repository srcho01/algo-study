import sys
from bisect import bisect_left
from itertools import chain

input = sys.stdin.readline

numbers = set()
number_id = {}

points = []
n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    points.append((x, y))
    numbers.add(x)
    numbers.add(y)

numbers = sorted(list(numbers))
for i, num in enumerate(numbers):
    number_id[num] = i + 1

MAX = len(numbers)
field = [[0] * (MAX+1) for _ in range(MAX+1)]
for x, y in points:
    field[number_id[x]][number_id[y]] += 1
    
for i in range(1, MAX+1):
    for j in range(1, MAX+1):
        field[i][j] += field[i-1][j] + field[i][j-1] - field[i-1][j-1]

ans = n+1
for i in range(1, MAX+1):
    for j in range(1, MAX+1):
        f1 = field[i][j]
        f2 = field[i][MAX] - field[i][j]
        f3 = field[MAX][j] - field[i][j]
        f4 = field[MAX][MAX] - f1 - f2 - f3
        ans = min(ans, max(f1, f2, f3, f4))
        
print(ans)
import sys

input = sys.stdin.readline

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]

for k in range(n):
    for a in range(n):
        for b in range(n):
            if g[a][k] == 1 and g[k][b] == 1:
                g[a][b] = 1

for line in g:
    print(*line)
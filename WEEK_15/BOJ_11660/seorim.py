import sys

input = sys.stdin.readline

n, m = map(int, input().split())
chart = [[0] + list(map(int, input().split())) for _ in range(n)]
chart = [[0] * (n+1)] + chart

for i in range(1, n+1):
    for j in range(1, n+1):
        chart[i][j] += chart[i-1][j] + chart[i][j-1] - chart[i-1][j-1]
        
for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    
    print(chart[x2][y2] - chart[x2][y1-1] - chart[x1-1][y2] + chart[x1-1][y1-1])
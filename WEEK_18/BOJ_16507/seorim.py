import sys

input = sys.stdin.readline

n, m, q = map(int, input().split())

photo = [[0] + list(map(int, input().split())) for _ in range(n)]
photo = [[0] * (m+1)] + photo

for i in range(1, n+1):
    for j in range(1, m+1):
        photo[i][j] += photo[i-1][j] + photo[i][j-1] - photo[i-1][j-1]

for _ in range(q):
    r1, c1, r2, c2 = map(int, input().split())
    total = photo[r2][c2] - photo[r2][c1-1] - photo[r1-1][c2] + photo[r1-1][c1-1]
    pixels = (r2-r1+1) * (c2-c1+1)
    
    print(total // pixels)
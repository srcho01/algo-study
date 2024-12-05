import sys

input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

ans = 0
for i in range(n):
    for j in range(m-3):
        ans = max(ans, sum(board[i][j:j+4]))

for j in range(m):
    for i in range(n-3):
        ans = max(ans, sum(board[x][j] for x in range(i, i+4)))
        
for i in range(n-1):
    for j in range(m-1):
        ans = max(ans, sum([board[i][j], board[i+1][j], board[i][j+1], board[i+1][j+1]]))
        
for i in range(n):
    for j in range(m-2):
        base = sum(board[i][j:j+3])
        if i >= 1:
            for y in [j, j+1, j+2]:
                ans = max(ans, base + board[i-1][y])
        if i < n-1:
            for y in [j, j+1, j+2]:
                ans = max(ans, base + board[i+1][y])
            
for j in range(m):
    for i in range(n-2):
        base = sum(board[x][j] for x in range(i, i+3))
        if j >= 1:
            for x in [i, i+1, i+2]:
                ans = max(ans, base + board[x][j-1])
        if j < m-1:
            for x in [i, i+1, i+2]:
                ans = max(ans, base + board[x][j+1])

for i in range(1, n-1):
    for j in range(m-1):
        base = board[i][j] + board[i][j+1]
        ans = max(ans, base + board[i-1][j] + board[i+1][j+1])
        ans = max(ans, base + board[i-1][j+1] + board[i+1][j])
        
for i in range(n-1):
    for j in range(1, m-1):
        base = board[i][j] + board[i+1][j]
        ans = max(ans, base + board[i][j+1] + board[i+1][j-1])
        ans = max(ans, base + board[i][j-1] + board[i+1][j+1])

print(ans)
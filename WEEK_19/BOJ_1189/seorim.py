import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())
mp = [list(input()) for _ in range(n)]

ans = 0
di = [(0, -1), (0, 1), (1, 0), (-1, 0)]
visited = [[False] * m for _ in range(n)]

def dfs(x, y, dist):
    global n, m, k, ans
    
    if x == 0 and y == m-1:
        if dist == k:
            ans += 1
        return
    
    for dx, dy in di:
        nx, ny = x + dx, y + dy
        if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
        if mp[nx][ny] == 'T' or visited[nx][ny]: continue
        
        visited[nx][ny] = True
        dfs(nx, ny, dist + 1)
        visited[nx][ny] = False
        
visited[n-1][0] = True
dfs(n-1, 0, 1)
print(ans)
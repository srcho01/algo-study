import sys

input = sys.stdin.readline
direction = [(0, -1), (0, 1), (-1, 0), (1, 0)]
A = ord('A')

r, c = map(int, input().split())
board = [list(input().rstrip()) for _ in range(r)]

longest = -1
visited = [False] * 26

def dfs(x, y, cnt):
    global longest
    
    longest = max(longest, cnt)
    
    for dx, dy in direction:
        nx = x + dx
        ny = y + dy
        
        if nx < 0 or nx >= r or ny < 0 or ny >= c: continue
        
        alphabet = ord(board[nx][ny])
        if not visited[alphabet - A]:
            visited[alphabet - A] = True
            dfs(nx, ny, cnt+1)
            visited[alphabet - A] = False

visited[ord(board[0][0]) - A] = True
dfs(0, 0, 1)

print(longest)
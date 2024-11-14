import sys

input = sys.stdin.readline

n, m = map(int, input().split())
r, c, d = map(int, input().split())

# 0 : 위 / 1 : 오 / 2 : 아래 / 3 : 왼
room = [list(map(int, input().split())) for _ in range(n)]
di = [(-1, 0), (0, 1), (1, 0), (0, -1)]


def has_dirty(r, c):
    for dx, dy in di:
        nx, ny = r + dx, c + dy
        
        if room[nx][ny] == 0:
            return True
    
    return False

cnt = 0
while True:
    if room[r][c] == 0:
        cnt += 1
        room[r][c] = 2
    
    if has_dirty(r, c):
        d = (d+3) % 4
        nx, ny = r + di[d][0], c + di[d][1]
        if room[nx][ny] == 0:
            r, c = nx, ny        
    else:
        back = (d+2) % 4
        dx, dy = di[back]
        nx, ny = r + dx, c + dy
        
        if room[nx][ny] != 1:
            r, c = nx, ny
        else:
            break
        
print(cnt)
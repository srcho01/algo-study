import sys

input = sys.stdin.readline

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

def status(x1, y1, x2, y2):
    impurities, jewel = 0, 0
    for i in range(x1, x2):
        for j in range(y1, y2):
            if board[i][j] == 1:
                impurities += 1
            if board[i][j] == 2:
                jewel += 1

    if impurities == 0 and jewel != 1:  # 더 이상 자를 수 없음
        return 0
    if impurities == 0 and jewel == 1:  # 완성
        return 1
    return 2  # 더 자를 수 있음
    

def daq(x1, y1, x2, y2, direction):
    stat = status(x1, y1, x2, y2)
    
    if stat == 0:
        return 0
    if stat == 1:
        return 1
    
    cnt = 0
    if direction == 1:  # 가로선
        for i in range(x1+1, x2-1):
            if any(board[i][j] == 1 for j in range(y1, y2)) and all(board[i][j] != 2 for j in range(y1, y2)):
                cnt += daq(x1, y1, i, y2, -direction) * daq(i+1, y1, x2, y2, -direction)
    
    if direction == -1:  # 세로선
        for j in range(y1+1, y2-1):
            if any(board[i][j] == 1 for i in range(x1, x2)) and all(board[i][j] != 2 for i in range(x1, x2)):
                cnt += daq(x1, y1, x2, j, -direction) * daq(x1, j+1, x2, y2, -direction)
                
    return cnt

ans = daq(0, 0, n, n, 1) + daq(0, 0, n, n, -1)
print(ans if ans != 0 else -1)
import sys

n = int(sys.stdin.readline())

chess = [0] * n

def check(row, col):
    for chess_row in range(row):
        chess_col = chess[chess_row]
        if chess_col == col or chess_row - chess_col == row - col or chess_row + chess_col == row + col:
            return False

    return True

ans = 0
def bt(row):
    global n, ans
    
    if row == n:
        ans += 1
        return
    
    for col in range(n):
        if check(row, col):
            chess[row] = col
            bt(row + 1)

bt(0)
print(ans)
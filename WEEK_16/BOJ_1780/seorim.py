import sys

input = sys.stdin.readline

n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]

cnt = [0] * 3  # 0, 1, -1

def daq(x, y, size):
    num = paper[x][y]
    flag = False
    
    for i in range(size):
        for j in range(size):
            if paper[x+i][y+j] != num:
                flag = True
                break
        
        if flag: break
        
    if not flag:  # 종이가 모두 같은 수
        cnt[num] += 1
    else:  # 종이를 9개로 자르기
        next_size = size // 3
        for i in range(0, size, next_size):
            for j in range(0, size, next_size):
                daq(x+i, y+j, next_size)
                
daq(0, 0, n)

for i in [-1, 0, 1]:
    print(cnt[i])
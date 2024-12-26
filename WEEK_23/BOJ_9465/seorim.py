import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    sticker = [[0] + list(map(int, input().split())) for _ in range(2)]
    
    for j in range(2, n+1):
        for i in range(2):
            sticker[i][j] += max(sticker[1-i][j-1], sticker[1-i][j-2])
        
    print(max(sticker[0][n], sticker[1][n]))
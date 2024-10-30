import sys

input = sys.stdin.readline

n, k = map(int, input().split())
k = min(k, n-k)

pascal = [[1] * (i+1) for i in range(n+1)]

for i in range(2, n+1):
    for j in range(1, min(i, k+1)):
        pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % 10007
        
print(pascal[n][k])
import sys

MOD = 1_000_000_000
n, k = map(int, sys.stdin.readline().split())

dp = [[0] * (n+1) for _ in range(k+1)]
for i in range(n+1):
    dp[1][i] = 1
for i in range(1, k+1):
    dp[i][0] = 1

for i in range(2, k+1):
    for j in range(1, n+1):
        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD
        
print(dp[k][n])
import sys

n, l, i = map(int, sys.stdin.readline().split())

dp = [[0 for _ in range(n+1)] for _ in range(n+1)]

dp[0][0] = 1

for k in range(1, n+1):
    dp[k][0] = 1
    for j in range(1, n+1):
        dp[k][j] = dp[k-1][j-1] + dp[k-1][j]
        
ans = ""
for k in range(n-1, -1, -1):
    if i > sum(dp[k][:l+1]):
        ans += "1"
        i -= sum(dp[k][:l+1])
        l -= 1
    else:
        ans += "0"

print(ans)
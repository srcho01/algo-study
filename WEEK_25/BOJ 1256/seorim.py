import sys

n, m, k = map(int, sys.stdin.readline().split())

def C(n, r):
    r = min(r, n-r)
    
    ret = 1
    for i in range(r):
        ret *= n - i
    for i in range(2, r+1):
        ret //= i
    
    return ret

if C(n+m, n) < k:
    print(-1)
    exit()
    
dp = [[0] * (m+1) for _ in range(n+1)]
for i in range(1, n+1):
    dp[i][0] = 1
for j in range(1, m+1):
    dp[0][j] = 1
    
for i in range(1, n+1):
    for j in range(1, m+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1]

ans = ""
while n > 0 and m > 0:
    if k <= dp[n-1][m]:
        ans += "a"
        n -= 1
    else:
        k -= dp[n-1][m]
        ans += "z"
        m -= 1

ans += "a" * n + "z" * m

print(ans)
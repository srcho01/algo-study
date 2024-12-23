import sys

n = int(sys.stdin.readline())
MOD = 10 ** 9

if n < 10:
    print(0)
    exit()
    
dp = [[[0] * (2**10) for _ in range(10)] for _ in range(n+1)]
for i in range(1, 10):
    bit = 1 << i
    dp[1][i][bit] = 1

for i in range(2, n+1):
    # 끝자리가 0으로 끝나는 경우
    for bit in range(2**10):
        new_bit = bit | 1
        dp[i][0][new_bit] += dp[i-1][1][bit] % MOD
    
    # 끝자리가 9로 끝나는 경우
    for bit in range(2**10):
        new_bit = bit | (1 << 9)
        dp[i][9][new_bit] += dp[i-1][8][bit] % MOD
    
    # 나머지
    for j in range(1, 9):
        for bit in range(2**10):
            new_bit = bit | (1 << j)
            dp[i][j][new_bit] += (dp[i-1][j-1][bit] + dp[i-1][j+1][bit]) % MOD

ans = 0
for i in range(10):
    ans += dp[n][i][-1]
    
print(ans % MOD)
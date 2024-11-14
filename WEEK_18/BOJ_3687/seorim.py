import sys

input = sys.stdin.readline

MAX = 100

need_stick = [0, 0, '1', '7', '4', '2', '0', '8']

min_dp = [10 ** 15] * (MAX+1)
min_dp[0] = min_dp[1] = ""
for i in range(2, 8):
    min_dp[i] = need_stick[i]
min_dp[6] = '6'

for i in range(8, MAX+1):
    for j in range(2, 8):
        if i-j >= 2:
            num = need_stick[j]
            if j == 6:
                min_dp[i] = min(min_dp[i], int(min_dp[i-j] + num), int('6' + min_dp[i-j]))
            else:
                min_dp[i] = min(min_dp[i], int(min_dp[i-j] + num), int(num + min_dp[i-j]))
    
    min_dp[i] = str(min_dp[i])
    
t = int(input())
for _ in range(t):
    n = int(input())
    max_num = ""
    if n % 2 == 1:
        max_num += '7'
        max_num += '1' * ((n-3) // 2)
    else:
        max_num += '1' * (n // 2)
    
    print(min_dp[n], max_num)
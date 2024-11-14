import sys

input = sys.stdin.readline

n = int(input())
arr = [0] + list(map(int, input().split()))
dp = [0] * (n+1)
dp[1] = arr[1]

for i in range(2, n+1):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + arr[i])

print(max(dp))
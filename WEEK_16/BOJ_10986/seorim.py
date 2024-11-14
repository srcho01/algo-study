import sys

input = sys.stdin.readline

n, m = map(int, input().split())
A = list(map(int, input().split()))
r = [0] * m

prefix_sum = 0
for i in range(n):
    prefix_sum += A[i]
    r[prefix_sum % m] += 1

cnt = r[0]
for i in range(m):
    # nC2 = n(n-1) / 2
    cnt += r[i] * (r[i]-1) // 2

print(cnt)
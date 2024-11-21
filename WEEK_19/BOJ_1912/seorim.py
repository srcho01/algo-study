import sys

input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
for i in range(1, n):
    li[i] += li[i-1]

mini = min(li[0], 0)
for i in range(1, n):
    tmp = li[i]
    li[i] = max(li[i-1], li[i] - mini)
    mini = min(mini, tmp)
        
print(li[-1])
import sys
from math import inf

input = sys.stdin.readline

k = int(input())
n = int(input())

dp = [set() for _ in range(9)]

for i in range(1, 9):
    dp[i].add(int(str(k) * i))

for i in range(1, 9):
    for j in range(1, 9):
        if i + j > 8: continue
        
        for a in dp[i]:
            for b in dp[j]:
                dp[i+j].add(a + b)
                dp[i+j].add(a * b)
                dp[i+j].add(max(a, b) // min(a, b))
                if a != b: dp[i+j].add(abs(a - b))
                
for _ in range(n):
    num = int(input())
    
    for i in range(1, 9):
        if num in dp[i]:
            print(i)
            break
    else:
        print("NO")
import sys
from collections import defaultdict

input = sys.stdin.readline

s = input().rstrip()
s_size = len(s)
n = int(input())
csum = defaultdict(lambda: [0] * s_size)

for i, char in enumerate(s):
    csum[char][i] = 1

for key, value in csum.items():
    for i in range(1, s_size):
        value[i] += value[i-1]

for _ in range(n):
    char, start, end = map(str, input().rstrip().split())
    start, end = int(start), int(end)
    
    if start > 0:
        print(csum[char][end] - csum[char][start-1])
    else:
        print(csum[char][end])
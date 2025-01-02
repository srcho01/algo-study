import sys

input = sys.stdin.readline

n = int(input())
budget = list(map(int, input().split()))
m = int(input())

if sum(budget) <= m:
    print(max(budget))
    exit()
    
start = 0
end = max(budget)

while start < end:
    mid = (start+end) // 2
    
    total = 0
    for b in budget:
        total += min(b, mid)
    
    if m < total:
        end = mid
    else:
        start = mid + 1

print(start-1)
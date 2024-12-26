import sys
input = sys.stdin.readline

n, k = map(int, input().split())
friend = []
for _ in range(n):
    name = input().rstrip()
    friend.append(len(name))
    
ans = 0
window = [0] * 21
for i in range(k):
    window[friend[i]] += 1
    
for i in range(n-k):
    curr = friend[i]
    window[curr] -= 1
    window[friend[i+k]] += 1
    ans += window[curr]
    
for i in range(n-k, n):
    curr = friend[i]
    window[curr] -= 1
    ans += window[curr]

print(ans)
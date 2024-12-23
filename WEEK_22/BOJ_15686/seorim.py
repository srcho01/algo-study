import sys
from math import inf

input = sys.stdin.readline

n, m = map(int, input().split())
house = []
chicken = []

for i in range(n):
    line = list(map(int, input().split()))
    for j in range(n):
        if line[j] == 1:
            house.append((i, j))
        elif line[j] == 2:
            chicken.append((i, j))

def chicken_dist(chosen_chicken):
    ret = 0
    for h in house:
        dist = inf
        for c in chosen_chicken:
            dist = min(dist, abs(h[0] - c[0]) + abs(h[1] - c[1]))
        ret += dist
    
    return ret    

ans = inf
chosen_chicken = []
def bt(depth):
    global ans, m
    
    if len(chosen_chicken) == m:
        ans = min(ans, chicken_dist(chosen_chicken))
        return
    elif depth >= len(chicken):
        return

    bt(depth+1)
    
    chosen_chicken.append(chicken[depth])
    bt(depth+1)
    chosen_chicken.pop()
    
bt(0)
print(ans)
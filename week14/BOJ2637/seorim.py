import sys
import copy

input = sys.stdin.readline

n = int(input())
m = int(input())


def dfs(parts, toy, curr):
    if toy[curr][0] == 0:
        for next, cnt in parts[curr]:
            if toy[next][0] == 0:
                dfs(parts, toy, next)
                
            for key, value in toy[next].items():
                toy[curr][key] += value * cnt
            
        toy[curr][0] = 1


parts = [[] for _ in range(n+1)]
for _ in range(m):
    x, y, k = map(int, input().split())
    parts[x].append((y, k))

basic = {i: 0 for i in range(1, n+1) if not parts[i]}

toy = {}
for i in range(1, n+1):
    toy[i] = copy.deepcopy(basic)
    if len(parts[i]) == 0:
        toy[i][0] = 1
        toy[i][i] = 1
    else:
        toy[i][0] = 0
        
for i in range(1, n+1):
    if not i in basic.keys():
        dfs(parts, toy, i)
        
for key, value in sorted(toy[n].items(), key=lambda x: x[0])[1:]:
    print(key, value)
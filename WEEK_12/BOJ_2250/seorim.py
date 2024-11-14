import sys
from collections import defaultdict

input = sys.stdin.readline

n = int(input())
tree = [0] * (n+1)
hasParent = [False] * (n+1)

for i in range(1, n+1):
    p, lc, rc = map(int, input().split())
    tree[p] = [lc, rc]
    if lc != -1:
        hasParent[lc] = True
    if rc != -1:
        hasParent[rc] = True

root = -1
for i in range(1, n+1):
    if not hasParent[i]:
        root = i
        break
  
cols = defaultdict(list)

num = 1
def dfs(node, level):
    global num
    
    if node != -1:
        dfs(tree[node][0], level + 1) # 왼쪽
        
        # 가운데 방문
        cols[level].append(num)
        num += 1
        
        dfs(tree[node][1], level + 1) # 오른쪽

dfs(root, 1)

ans = [0, 0]
maxWidth = -1
for level, clist in cols.items():
    width = clist[-1] - clist[0] + 1
    if width > maxWidth:
        ans[0] = level
        ans[1] = width
        maxWidth = width
    elif width == maxWidth and level < ans[0]:
        ans[0] = level
        
print(*ans)
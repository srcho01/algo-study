import sys

input = sys.stdin.readline

n = int(input())
tree = [[] for _ in range(n)]
parents = list(map(int, input().split()))

for node, parent in enumerate(parents):
    if parent != -1:
        tree[parent].append(node)
        
rm = int(input())

remove_node = [False] * n

def dfs(node):
    remove_node[node] = True
    
    for nxt in tree[node]:
        dfs(nxt)

dfs(rm)

cnt = 0
for i in range(n):
    if remove_node[i]: continue
    
    for child in tree[i]:
        if not remove_node[child]:
            break
    else:
        cnt += 1

print(cnt)
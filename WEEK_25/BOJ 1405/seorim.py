import sys

n, ep, wp, sp, np = map(int, sys.stdin.readline().split())
prob = [ep/100, wp/100, sp/100, np/100]
direction = [(1, 0), (-1, 0), (0, 1), (0, -1)]
visited = [[False] * 29 for _ in range(29)]
visited[14][14] = True

def bt(depth, prev_x, prev_y, way):
    global n
    
    x, y = prev_x + direction[way][0], prev_y + direction[way][1]
    if visited[x][y]:
        return 0
    
    if depth == n:
        return prob[way]
    
    next_prob = 0
    visited[x][y] = True
    for i in range(4):
        next_prob += bt(depth+1, x, y, i)
    visited[x][y] = False
    
    return prob[way] * next_prob

ans = 0
for i in range(4):
    ans += bt(1, 14, 14, i)

print(ans)
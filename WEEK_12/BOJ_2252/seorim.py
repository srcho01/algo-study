import sys

input = sys.stdin.readline
n, m = map(int, input().split())

indegree = [0] * (n+1)
graph = [[] for _ in range(n+1)]

# 진입 차수 계산
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    indegree[v] += 1

# 진입 차수 0인 학생 큐에 넣기
queue = []
for student, dg in enumerate(indegree[1:], 1):
    if dg == 0:
        queue.append(student)

# 순서 탐색
row = []
for _ in range(n):
    curr = queue.pop(0)
    row.append(curr)
    
    for next in graph[curr]:
        indegree[next] -= 1
        if indegree[next] == 0:
            queue.append(next)
            
print(" ".join(map(str, row)))
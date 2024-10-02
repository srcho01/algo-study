import sys
from queue import PriorityQueue

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    num = []
    for _ in range(n//10 + 1):
        num += list(map(int, input().split()))
    
    front = PriorityQueue()
    mid = 0
    back = PriorityQueue()
      
    ans = []
    mid = num[0]
    ans.append(mid)
    
    for i in range(1, n):
        x = num[i]
        
        if x >= mid:
            back.put(x)
        else:
            front.put((-x, x))
        
        if i % 2 == 0:
            if front.qsize() > back.qsize():
                back.put(mid)
                mid = front.get()[1]
            elif front.qsize() < back.qsize():
                front.put((-mid, mid))
                mid = back.get()
            
            ans.append(mid)
    
    cnt = len(ans)
    print(cnt)
    
    i = 0
    while i < (cnt // 10) * 10:
        print(" ".join(map(str, ans[i:i+10])))
        i += 10
    
    print(" ".join(map(str, ans[i:])))
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
lecture = list(map(int, input().split()))

start = max(lecture)
end = sum(lecture) + 1

ans = 0
while start < end:
    mid = (start + end) // 2
    
    num = 1
    time = 0
    for lec in lecture:
        if time + lec <= mid:
            time += lec
        else:
            num += 1
            time = lec
            
    if num <= m:
        ans = mid
        end = mid
    else:
        start = mid + 1
        
print(ans)
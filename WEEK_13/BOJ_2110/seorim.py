import sys

input = sys.stdin.readline

n, c = map(int, input().split())
router = sorted([int(input()) for _ in range(n)])


def install(dist):
    cnt = 1
    last_installed = router[0]
    
    for r in router[1:]:
        if r - last_installed >= dist:
            cnt += 1
            last_installed = r
            
    return cnt


start = 1
end = router[-1] - router[0] + 1

while start < end:
    mid = (start + end) // 2
    
    cnt = install(mid)
    
    if cnt < c:
        end = mid
    else:
        start = mid + 1

print(start - 1)
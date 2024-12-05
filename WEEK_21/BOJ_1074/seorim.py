import sys

input = sys.stdin.readline

n, r, c = map(int, input().split())

def dac(size, num):
    global r, c
    
    if size == 2:
        if r % 2 == 1:
            num += 2
        if c % 2 == 1:
            num += 1
        
        print(num) 
        return
    
    size //= 2
    if r >= size:
        num += size * size * 2
        r -= size
    if c >= size:
        num += size * size
        c -= size
    
    dac(size, num)
    
dac(2**n, 0)
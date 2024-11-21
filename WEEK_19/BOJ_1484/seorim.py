# G = (현재 몸무게) ** 2 - (기억하고 있던 몸무게) ** 2
# 현재 몸무게 >= 기억하고 있던 몸무게
# G = (현몸 + 기몸)(현몸 - 기몸)

import sys
from math import sqrt

n = int(sys.stdin.readline())

ans = []
for sm in range(n, int(sqrt(n)), -1):
    diff = n // sm
    if sm * diff != n: continue
    
    if (sm + diff) % 2 == 0:
        ans.append((sm + diff) // 2)

if len(ans) == 0:
    print(-1)
else:
    print("\n".join(map(str, sorted(ans))))
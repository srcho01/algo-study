import sys
from collections import defaultdict

distribution = defaultdict(int)
total = 0
while True:
    tree = sys.stdin.readline().strip()
    if not tree: break
    
    distribution[tree] += 1
    total += 1

distribution = sorted(distribution.items(), key=lambda x: x[0])
for name, num in distribution:
    print(name, end=" ")
    print("%0.4f" % (num / total * 100))
    print(round(num / total * 100, 4))
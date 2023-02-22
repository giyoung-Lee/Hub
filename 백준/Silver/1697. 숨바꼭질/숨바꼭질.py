import sys
from collections import deque
input = sys.stdin.readline
INF = int(1e9)

n, k = map(int, input().split())

q = deque([])
visited = set()
distance = [INF]  * 100001

def visit(x, cnt):
    if (x) not in visited:
        q.append((x, cnt))
        distance[x] = min(distance[x], cnt)
        visited.add((x))

visit(n, 0)

if n >= k:
    print(n-k)
else:
    while len(q) != 0:
        x, cnt = q.popleft()

        if x+1 <= 100000:
            visit(x+1, cnt+1)
        
        if x-1 >= 0:
            visit(x-1, cnt+1)

        if 2*x <= 100000:
            visit(2*x, cnt+1)    
    print(distance[k])

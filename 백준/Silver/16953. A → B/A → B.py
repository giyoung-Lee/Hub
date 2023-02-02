import sys
from collections import deque
input = sys.stdin.readline
a, b = map(int, input().split())

q = deque([])
q.append((a, 0))
visited = set()
flag = False
result = 0


while len(q) != 0:
    val, dist = q.popleft()
    if val > int(1e9):
        continue
    if val == b:
        print(dist + 1)
        flag = True
        break

    for oper in ['*', '+']:
        n_val = val
        if oper == '*':
            n_val *= 2
        if oper == '+':
            n_val *= 10
            n_val += 1

        if n_val not in visited:
            q.append((n_val, dist + 1))
            visited.add(n_val)


if not flag:
    print(-1)
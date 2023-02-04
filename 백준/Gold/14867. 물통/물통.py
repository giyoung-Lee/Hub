import sys
from collections import deque

input = sys.stdin.readline
a, b, c, d = map(int, input().split())

q = deque([])
q.append((0, 0, 0))
visited = set()
flag = False
result = 0

def visit(x, y, cnt):
    if (x, y) not in visited:
        q.append((x, y, cnt))
        visited.add((x, y))


while len(q) != 0:
    x, y, cnt = q.popleft()
    if x == c and y == d:
        print(cnt)
        flag = True
        break

    # A 비우기
    nx, ny = 0, y
    visit(nx, ny, cnt+1)

    # B 비우기
    nx, ny = x, 0
    visit(nx, ny, cnt+1)

    # A 채우기
    nx, ny = a, y
    visit(nx, ny, cnt + 1)

    # B 채우기
    nx, ny = x, b
    visit(nx, ny, cnt+1)

    # 옮기기 1
    if x + y < a:
        nx, ny = x+y, 0
    else:
        nx, ny = a, x + y - a
    visit(nx, ny, cnt + 1)

    # 옮기기 2
    if x + y < b:
        nx, ny = 0, x+y
    else:
        nx, ny = x + y - b, b
    visit(nx, ny, cnt + 1)


if not flag:
    print(-1)
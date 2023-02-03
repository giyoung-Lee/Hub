import sys
from collections import deque
input = sys.stdin.readline
a, b = map(int, input().split())

q = deque([])
q.append((a, ''))
visited = set()
flag = False
flag2 = False
result = 0


while len(q) != 0:
    val, result = q.popleft()
    if val > int(1e9):
        continue

    if a == b:
        print(0)
        flag2 = True
        break

    if val == b:
        print(result)
        flag = True
        break

    for oper in ['*', '+', '-', '/']:
        n_val = val

        if oper == '*':
            n_val *= n_val
            if n_val not in visited:
                q.append((n_val, result+'*'))
                visited.add(n_val)

        if oper == '+':
            n_val += n_val

            if n_val not in visited:
                q.append((n_val, result+'+'))
                visited.add(n_val)

        if oper == '-':
            n_val -= n_val
            if n_val not in visited:
                q.append((n_val, result+'-'))
                visited.add(n_val)

        if oper == '/' and n_val != 0:
            n_val /= n_val
            if n_val not in visited:
                q.append((n_val, result+'/'))
                visited.add(n_val)


if not flag2:
    if not flag:
        print(-1)
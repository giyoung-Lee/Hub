from collections import deque

n, m = map(int, input().split())
_list = [[] * m for _ in range(n+1)]
result = []

for _ in range(m):
    com1, com2 = map(int, input().split())
    _list[com2].append(com1)

def bfs(v):
    q = deque([v])
    visited = [False] * (n+1)
    visited[v] = True
    count = 1
    while q:
        v = q.popleft()
        for e in _list[v]:
            if not visited[e]:
                q.append(e)
                visited[e] = True
                count +=1

    return count

max_val = -1

for i in range(1, n+1):
    c = bfs(i)
    if c > max_val:
        result = [i]
        max_val = c
    elif c == max_val:
        result.append(i)
        max_val = c

for e in result:
    print(e, end=" ")
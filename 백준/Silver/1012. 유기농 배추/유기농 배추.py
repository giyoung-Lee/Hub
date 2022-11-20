import sys
sys.setrecursionlimit(100000)


def dfs(x, y):
    visited[x][y] = True
    direction = [(0, -1), (0, 1), (-1, 0), (1, 0)]

    for dx, dy in direction:
        nx = dx + x
        ny = dy + y
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        if array[nx][ny] and not visited[nx][ny]:
            dfs(nx, ny)


for _ in range(int(input())):
    m, n, k = map(int, input().split())

    visited = [[False] * m for _ in range(n)]
    array = [[0] * m for _ in range(n)]
    result = 0

    for _ in range(k):
        y, x = map(int, input().split())
        array[x][y] = 1

    for i in range(n):
        for j in range(m):
            if array[i][j] and not visited[i][j]:
                dfs(i, j)
                result += 1

    print(result)
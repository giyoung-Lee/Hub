import sys
sys.setrecursionlimit(10000)

m, n, k = map(int, input().split())
g = [[0] * n for i in range(m)]

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())

    for i in range(y1, y2):
        for j in range(x1, x2):
            g[i][j] = 1


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

result = []
count = 1

def dfs(x, y):
    global count
    g[x][y] = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < m and 0 <= ny < n and g[nx][ny] == 0:
            count += 1
            dfs(nx, ny)

for i in range(m):
    for j in range(n):
        if g[i][j] == 0:
            dfs(i, j)
            result.append(count)
            count = 1

print(len(result))
print(*sorted(result))
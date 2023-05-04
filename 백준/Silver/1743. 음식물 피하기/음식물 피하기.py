import sys
sys.setrecursionlimit(100000)
n, m, k = map(int, input().split())

arr = [[0] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
answer = []

for i in range(k):
    a, b = map(int, input().split())
    arr[a-1][b-1] = 1

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y):
    score = 1
    visited[x][y] = True

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue

        if arr[nx][ny] == 0:
            continue

        if arr[nx][ny] == 1 and not visited[nx][ny]:
            score += dfs(nx, ny)

    return score

for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            answer.append(dfs(i, j))

print(max(answer))
import sys
input = sys.stdin.readline
sys.setrecursionlimit(int(1e5))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

n = int(input())
graph = [[] for _ in range(n)]

for i in range(n):
    for x in input():
        graph[i].append(x)

answer = 0
visited = [[False] * n for _ in range(n)]

def dfs(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx <= -1 or nx >= n or ny <= -1 or ny >= n:
            continue
        if not visited[nx][ny]:
            if graph[x][y] == graph[nx][ny]:
                visited[nx][ny] = True
                dfs(nx, ny)

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visited[i][j] = True
            dfs(i, j)
            answer += 1

print(answer, end=' ')

for i in range(n):
    for j in range(n):
        if graph[i][j] == 'R':
            graph[i][j] = 'G'


answer = 0
visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            visited[i][j] = True
            dfs(i, j)
            answer += 1

print(answer)


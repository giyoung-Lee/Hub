from collections import deque

a, b = map(int, input().split())
arr = [list(map(int, input())) for _ in range(a)]

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

def bfs(x, y):
    q = deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= a or nx < 0 or ny >= b or ny < 0:
                continue

            if arr[nx][ny] == 0:
                continue

            if arr[nx][ny] == 1:
                arr[nx][ny] = arr[x][y] + 1
                q.append((nx, ny))

    return arr[a-1][b-1]


print(bfs(0, 0))
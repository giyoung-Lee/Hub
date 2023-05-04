a, b = map(int, input().split())

arr = [list(map(str, input())) for _ in range(b)]
visited = [[False] * a for _ in range(b)]

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]


def dfs(x, y, team):
    result = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= b or nx <= -1 or ny >= a or ny <= -1:
            continue
        if arr[nx][ny] == team:
            arr[nx][ny] = 'visited'
            result += dfs(nx, ny, team)

    return result


w_score = 0
b_score = 0

for i in range(b):
    for j in range(a):
        if arr[i][j] == "W":
            arr[i][j] = 'visited'
            tmp = dfs(i, j, "W")
            w_score += tmp**2

        elif arr[i][j] == "B":
            arr[i][j] = 'visited'
            tmp = dfs(i, j, "B")
            b_score += tmp**2

print(w_score, b_score)

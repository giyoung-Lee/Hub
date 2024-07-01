import sys
from collections import deque


def solution(land):
    n = len(land)
    m = len(land[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    result = [0 for _ in range(m)]

    for j in range(m):
        for i in range(n):
            if not visited[i][j] and land[i][j] == 1:
                bfs(i, j, visited, n, m, land, result)

    return max(result)


def bfs(x, y, visited, n, m, land, result):
    queue = deque([(x, y)])
    visited[x][y] = True
    area_amount = 0
    start_y, end_y = sys.maxsize, -sys.maxsize

    while queue:
        cx, cy = queue.popleft()
        area_amount += 1
        start_y, end_y = min(start_y, cy), max(end_y, cy)

        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx = cx + dx
            ny = cy + dy

            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and land[nx][ny] == 1:
                queue.append((nx, ny))
                visited[nx][ny] = True

    for col in range(start_y, end_y + 1):  # 해당 col범위에 대해 석유량 누적
        result[col] += area_amount
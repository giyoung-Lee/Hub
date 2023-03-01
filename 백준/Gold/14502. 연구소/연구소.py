from itertools import combinations
from collections import deque

n, m = map(int, input().split())

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 연구소 지도
lab = []
for _ in range(n):
    lab.append(list(map(int, input().split())))


# 벽을 세울 수 있는 공간 찾기
def get_walls(lab):
    walls = []
    for i in range(n):
        for j in range(m):
            if lab[i][j] == 0:
                walls.append((i, j))
    
    return walls

# 바이러스를 퍼뜨리는 함수
def spread_virus(lab, start):
    q = deque([start])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and lab[nx][ny] == 0:
                lab[nx][ny] = 2
                q.append((nx, ny))

# 안전 영역 크기
def get_sage_area(lab):
    safe = 0
    for i in range(n):
        for j in range(m):
            if lab[i][j] == 0:
                safe += 1
    
    return safe


# 조합을 이용하여 벽 3개를 세우는 모든 경우의 수
walls = get_walls(lab)
combi = list(combinations(walls, 3))

# 최대 안전 영역 크기 구하기
result = 0
for c in combi:
    # deepcopy 대신 슬라이싱을 이용해서 복사
    temp = [row[:] for row in lab]

    # 벽 세우기
    for i, j in c:
        temp[i][j] = 1

    # 바이러스 퍼뜨리기
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 2:
                spread_virus(temp, (i, j))

    # 안전 영역의 크기구하기
    result = max(result, get_sage_area(temp))

print(result)

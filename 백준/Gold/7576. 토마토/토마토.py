from collections import deque

M, N = map(int, input().split())

arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

queue = deque()

for y in range(N):
    for x in range(M):
        if arr[y][x] == 1:
            queue.append((y, x))

# 방향 벡터 (상, 하, 좌, 우)
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


# BFS 수행
def bfs():
    while queue:
        y, x = queue.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] == 0:
                arr[ny][nx] = arr[y][x] + 1  # 날짜를 증가시켜서 저장
                queue.append((ny, nx))


bfs()

# 결과 확인
max_days = 0
impossible = False

for y in range(N):
    for x in range(M):
        if arr[y][x] == 0: 
            impossible = True
        max_days = max(max_days, arr[y][x])

if impossible:
    print(-1)
else:
    print(max_days - 1)
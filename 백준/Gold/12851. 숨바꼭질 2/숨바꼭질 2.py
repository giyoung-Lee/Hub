from collections import deque

n, k = map(int, input().split())

time = [-1] * 100001
count = [0] * 100001

# 시작점 초기화
time[n] = 0
count[n] = 1

queue = deque([n])

while queue:
    x = queue.popleft()

    # x에서 갈 수 있는 위치를 모두 탐색
    for nx in (x-1, x+1, 2*x):
        # 범위를 벗어나는 경우 건너뜀
        if not (0 <= nx <= 100000):
            continue

        # 방문하지 않았을 경우
        if time[nx] == -1:
            # 이전 위치에서 1초 후에 이동하므로
            time[nx] = time[x] + 1
            # 방법의 수를 이전 위치에서 이동한 방법의 수와 더함
            count[nx] += count[x]
            # 큐에 추가
            queue.append(nx)
        # 이미 방문한 경우
        elif time[nx] == time[x] + 1:
            # 방법의 수를 누적
            count[nx] += count[x]

# 결과 출력
print(time[k])
print(count[k])

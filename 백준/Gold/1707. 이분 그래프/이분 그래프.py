import sys
input = sys.stdin.readline
from collections import deque


def bfs(x):
    q = deque([x])

    # 0 / 1 로 구분, 처음 노드는 0으로 칠함
    visited[x] = 0

    while len(q) != 0:
        x = q.popleft()

        # 인접한 노드를 확인
        for y in graph[x]:
            if visited[y] == -1: # 방문하지 않았다면
                # 0일경우 1로, 1일경우 0으로 칠하기 위한 로직
                visited[y] = (visited[x]+1) % 2
                q.append(y)


# 이분 그래프를 판별하는 함수
def is_bipartite():
    for x in range(1, v + 1):
        for y in graph[x]:
            if visited[x] == visited[y]:
                return False
    return True


for _ in range(int(input())):
    v, e = map(int, input().split())
    graph = [[] for _ in range(v+1)]

    for i in range(e):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    visited = [-1] * (v+1)

    for x in range(1, v+1):
        if visited[x] == -1:
            bfs(x)

    if is_bipartite():
        print("YES")
    else:
        print("NO")

import sys
input = sys.stdin.readline

sys.setrecursionlimit(int(1e6))

# DFS를 통해 사이클을 판별하는 문제
def is_cycle(x):
    visited[x] = True
    y = graph[x]

    # 다음 노드를 방문하지 않았다면
    if not visited[y]:
        is_cycle(y)

    # 방문 했지만, 완료되지 않았다면
    elif not finished[y]:
        # 사이클에 포함된 노드를 result에 저장
        while y != x:
            result.append(y)
            y = graph[y]
        # 여기까지 사이클의 모든 노드들이 result에 담김
        result.append(x)
    finished[x] = True


for _ in range(int(input())):
    n = int(input())
    graph = [0] + list(map(int, input().split()))
    visited = [False] * (n+1)
    finished = [False] * (n+1)
    result = []

    for x in range(1, n+1):
        if not visited[x]:
            is_cycle(x)

    print(n - len(result))
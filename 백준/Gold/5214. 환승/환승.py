import sys
input = sys.stdin.readline
from collections import deque

# 역의 개수(N), 간선의 개수(K), 하이퍼 튜브의 개수(M)
n, k, m = map(int, input().split())

# 그래프의 정보(N개의 역과 M개의 하이퍼 튜브는 모두 노드)
graph = [[] for _ in range(n+m+1)]

for i in range(1, m+1):
    arr = list(map(int, input().split()))

    for x in arr:
        graph[x].append(n+i)  # 노드 -> 하이퍼 튜브
        # 하이퍼 튜브의 노드 번호는 N+1번 부터 출발
        graph[n+i].append(x)  # 하이퍼 튜브 -> 노드


visited = set([1])  # 1번 노드에서 출발
queue = deque([(0, 1)])  # (거리, 노드 번호)
found = False

while queue:
    cost, now = queue.popleft()
    if now == n:  # N번 노드에 도착한 경우
        print(cost//2 + 1)  # 절반은 하이퍼 튜브
        found = True
        break
    for y in graph[now]:
        if y not in visited:
            queue.append((cost+1, y))  # 방문 처리
            visited.add(y)

if not found:
    print(-1)

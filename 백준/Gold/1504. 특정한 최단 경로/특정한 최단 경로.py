import sys
import heapq
input = sys.stdin.readline

n, m = map(int, input().split())
INF = int(1e9)
gp = [[] for i in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    gp[a].append((b, c))
    gp[b].append((a, c))

a, b = map(int, input().split())

def dijkstra(start):
    q = []
    # 시작 노드로 가기 위한 최단경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)

        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue

        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in gp[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐, 다른 노드로 가는 거리가 더 짧으면
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

# 1 -> A -> B -> N
# 2 -> B -> A -> N
# 이를 위해 3번 수행
# 1. 노드 1에서 출발하여 A or B 에 도착할 때
# 2. 노드 A에서 출발하여 B,N 에 도착할 때
# 3. 노드 B에서 출발하여 A,N 에 도착할 때


distance = [INF] * (n+1)
dijkstra(1)
d_1_to_a = distance[a]
d_1_to_b = distance[b]
distance = [INF] * (n+1) # 초기화
dijkstra(a)
d_a_to_b = distance[b]
d_a_to_n = distance[n]
distance = [INF] * (n+1) # 초기화
dijkstra(b)
d_b_to_a = distance[a]
d_b_to_n = distance[n]

route1 = d_1_to_a + d_a_to_b + d_b_to_n
route2 = d_1_to_b + d_b_to_a + d_a_to_n

result = min(route1, route2)
if result >= INF:
    print(-1)
else:
    print(result)

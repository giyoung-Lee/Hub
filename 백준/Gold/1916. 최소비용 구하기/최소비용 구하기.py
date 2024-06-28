import heapq

N = int(input())
M = int(input())

graph = {}
for i in range(M):
    start, dest, cost = map(int, input().split())

    if start not in graph:
        graph[start] = []
    if dest not in graph:
        graph[dest] = []
    graph[start].append((dest, cost))


start, dest = map(int, input().split())

dist = {node: float('inf') for node in range(1, N+1)}
dist[start] = 0

q_queue = [(dist[start], start)]

while q_queue:
    current_dist, node = heapq.heappop(q_queue)

    if current_dist > dist[node]:
        continue

    for neighbor, weight in graph[node]:
        distance = current_dist + weight

        if distance < dist[neighbor]:
            dist[neighbor] = distance
            heapq.heappush(q_queue, (distance, neighbor))

print(dist[dest])
import heapq

n = int(input())
array = []
_queue = []

for i in range(n):
    x, y = map(int, input().split())
    array.append((x, y))

array.sort()

for i in array:
    a = i[0]
    heapq.heappush(_queue, i[1])
    if a < len(_queue):
        heapq.heappop(_queue)

print(sum(_queue))
import sys
input = sys.stdin.readline

import heapq

n, k = map(int, input().split())

stone = []
for i in range(n):
    w, p = map(int, input().split())
    stone.append((w, p))

bags = []
for i in range(k):
    bag = int(input())
    bags.append(bag)


stone.sort()
bags.sort()

heap = []
cur = 0
result = 0

for bag in bags:
    while cur < n:
        w, p = stone[cur]

        if bag >= w:
            heapq.heappush(heap, -p)
            cur += 1
        else:
            break

    if len(heap) > 0:
        p = -heapq.heappop(heap)
        result += p

print(result)
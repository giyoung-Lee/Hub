import heapq

n, m = map(int, input().split())
_list = list(map(int, input().split()))

lq = []
rq = []
result = 0

lage = max(max(_list), -min(_list))

for i in _list:
    if i > 0:
        heapq.heappush(rq, -i)
    else:
        heapq.heappush(lq, i)

while rq:
    result += heapq.heappop(rq)
    for _ in range(m-1):
        if rq:
            heapq.heappop(rq)

while lq:
    result += heapq.heappop(lq)
    for _ in range(m-1):
        if lq:
            heapq.heappop(lq)

print(-result*2 - lage)
import heapq
n = int(input())
_list = []
result = []

for i in range(n):
    k = int(input())

    if k == 0:
        if _list:
            result.append(heapq.heappop(_list))
        else:
            result.append(0)
    else:
        heapq.heappush(_list, k)

for data in result:
    print(data)

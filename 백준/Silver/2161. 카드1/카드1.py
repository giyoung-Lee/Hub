from collections import deque

N = int(input())

arr = deque([i for i in range(1, N+1)])

while True:
    print(arr.popleft(), end=" ")
    if len(arr) == 0:
        break
    arr.append(arr.popleft())
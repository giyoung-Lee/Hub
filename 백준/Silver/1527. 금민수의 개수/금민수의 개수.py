import sys
from collections import deque
input = sys.stdin.readline

a, b = map(int, input().split())
result = 0
arr = []
queue = deque(['4', '7'])

while queue:
    num = queue.popleft()
    num_int = int(num)

    if num_int > b:
        continue

    arr.append(num_int)
    queue.append(num + '4')
    queue.append(num + '7')


for i in arr:
    if a <= i <= b:
        result += 1

print(result)
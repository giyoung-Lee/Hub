import sys
from collections import deque

input = sys.stdin.read
data = input().split()

N = int(data[0])

queue = deque()
index = 1
output = []

for _ in range(N):
    command = data[index]

    if command == "push":
        queue.append(data[index + 1])
        index += 2
    elif command == "front":
        if len(queue) == 0:
            output.append("-1")
        else:
            output.append(queue[0])
        index += 1
    elif command == "back":
        if len(queue) == 0:
            output.append("-1")
        else:
            output.append(queue[-1])
        index += 1
    elif command == "size":
        output.append(str(len(queue)))
        index += 1
    elif command == "empty":
        if len(queue) == 0:
            output.append("1")
        else:
            output.append("0")
        index += 1
    elif command == "pop":
        if len(queue) == 0:
            output.append("-1")
        else:
            output.append(queue.popleft())
        index += 1

# 한번에 출력
sys.stdout.write("\n".join(output) + "\n")
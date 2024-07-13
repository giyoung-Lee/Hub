import sys

input = sys.stdin.read
data = input().splitlines()

count = 0
idx = 0
n = int(data[idx])

while n != 0:
    count += 1
    idx += 1

    arr = []
    for i in range(n):
        arr.append(data[idx])
        idx += 1

    temp = [0] * (n + 1)
    for _ in range(2 * n - 1):
        num, letter = data[idx].split()
        num = int(num)

        if temp[num] == 0:
            temp[num] = 1
        else:
            temp[num] = 0

        idx += 1

    for i in range(1, len(temp)):
        if temp[i] == 1:
            print(f"{count} {arr[i - 1]}")
            break

    if idx < len(data):
        n = int(data[idx])
    else:
        break
import sys
input = sys.stdin.readline

c = int(input())

for i in range(c):
    arr = list(map(int, input().split()))

    temp = sum(arr[1:]) / arr[0]
    count = 0
    for j in range(1, len(arr)):
        if arr[j] > temp:
            count += 1

    print(f"{(count/arr[0]) * 100}%")
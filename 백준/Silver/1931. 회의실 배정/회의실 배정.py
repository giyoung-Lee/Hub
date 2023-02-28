import sys
input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    m, n = map(int, input().split())
    arr.append([m, n])


arr.sort(key=lambda x : x[0])
arr.sort(key=lambda x : x[1])


result = 1
now = arr[0][1]

for i in range(1, len(arr)):
    if now <= arr[i][0]:
        result += 1
        now = arr[i][1]


print(result)
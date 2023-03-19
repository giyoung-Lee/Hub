n = int(input())
arr = list(map(int, input().split()))

answer = 0
arr.sort()

if len(arr) == 1:
    answer = arr[0] * arr[0]
else:
    answer = arr[0] * arr[-1]

print(answer)
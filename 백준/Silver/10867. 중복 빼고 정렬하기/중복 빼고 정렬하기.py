N = int(input())
arr = set(map(int, input().split()))
arr = list(arr)
arr.sort()

for i in arr:
    print(i, end=" ")
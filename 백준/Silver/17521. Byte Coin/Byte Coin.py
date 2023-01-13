n, w = map(int, input().split())
arr = []

for i in range(n):
    arr.append(int(input()))

for i in range(n - 1):
    if arr[i] < arr[i+1]:
        cnt = w // arr[i]
        w += cnt * (arr[i+1] - arr[i])

print(w)
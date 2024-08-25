arr = list(map(int, input().split()))

max_v = -200
min_v = 200

if arr[0] + arr[1] > max_v:
    max_v = arr[0] + arr[1]

if arr[0] + arr[1] < min_v:
    min_v = arr[0] + arr[1]

if arr[0] - arr[1] > max_v:
    max_v = arr[0] - arr[1]

if arr[0] - arr[1] < min_v:
    min_v = arr[0] - arr[1]

print(max_v)
print(min_v)
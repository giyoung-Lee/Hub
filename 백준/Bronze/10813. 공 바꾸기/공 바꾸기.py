n, m = map(int, input().split())

arr = [ i for i in range(n+1) ]

for i in range(m):
    a, b = map(int, input().split())
    tmp = arr[a]
    arr[a] = arr[b]
    arr[b] = tmp

for i in range(1, len(arr)):
    print(arr[i], end=' ')
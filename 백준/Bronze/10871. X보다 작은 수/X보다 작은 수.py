n, m = map(int, input().split())
arr = list(map(int, input().split()))

for i in arr:
    if i < m:
        print(i, end=' ')

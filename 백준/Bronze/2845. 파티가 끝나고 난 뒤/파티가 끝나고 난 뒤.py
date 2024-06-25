L, P = map(int, input().split())
arr = list(map(int, input().split()))

temp = L * P
for i in arr:
    print(i-temp, end=" ")
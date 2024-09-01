n = int(input())
result = 1001


for i in range(n):
    a, b = map(int, input().split())

    if b >= a:
        if b < result:
            result = b

if result == 1001:
    print(-1)
else:
    print(result)
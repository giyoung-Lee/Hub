n = int(input())
temp = 1001
result = 0


for i in range(n):
    a, b = map(int, input().split())

    if a <= b:
        if b-a < temp:
            temp = b-a
            result = b


if temp == 1001:
    print(-1)
else:
    print(result)
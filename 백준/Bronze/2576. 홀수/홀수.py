min_ = 110
result = 0

for _ in range(7):
    n = int(input())

    if n % 2 == 1:
        result += n

        if n < min_:
            min_ = n

if result == 0:
    print(-1)
else:
    print(result)
    print(min_)
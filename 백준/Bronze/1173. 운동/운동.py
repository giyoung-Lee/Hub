N, m, M, T, R = map(int, input().split())

count = 0
result = 0
now = m

while True:
    if count == N:
        print(result)
        break
    elif m+T > M:
        print(-1)
        break

    result += 1

    if now+T <= M:
        now += T
        count += 1

    elif now+T > M:
        if now-R < m:
            now = m
        else:
            now -= R

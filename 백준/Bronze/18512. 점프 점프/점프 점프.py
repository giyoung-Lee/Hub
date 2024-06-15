X, Y, p1, p2 = map(int, input().split())

while True:
    if p1 == p2:
        print(p1)
        break
    elif p1 > 10000 or p2 > 10000:
        print(-1)
        break

    if p1 > p2:
        p2 += Y
    else:
        p1 += X
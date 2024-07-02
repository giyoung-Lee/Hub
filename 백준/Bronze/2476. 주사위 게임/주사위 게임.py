N = int(input())

cost = 0

for i in range(N):
    a, b, c = map(int, input().split())
    temp = 0

    if a == b == c:
        temp = 10000 + (a) * 1000
    elif a == b != c:
        temp = 1000 + (a) * 100
    elif a != b == c:
        temp = 1000 + (b) * 100
    elif a == c != b:
        temp = 1000 + (a) * 100
    elif a != b != c:
        temp = max(a, b, c) * 100

    if temp > cost:
        cost = temp

print(cost)
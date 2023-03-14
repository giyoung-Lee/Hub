a, b, c = map(int, input().split())

arr = []
result = 0

for i in range(3):
    x, y = map(int, input().split())
    arr.append((x, y))

t = max(arr[0][1], arr[1][1], arr[2][1])
p = [0] * (t+1)

for car in arr:
    for i in range(car[0], car[1]):
        p[i] += 1

for i in range(1, len(p)):
    if p[i] == 1:
        result += a
    elif p[i] == 2:
        result += 2 * b
    elif p[i] == 3:
        result += 3 * c

print(result)
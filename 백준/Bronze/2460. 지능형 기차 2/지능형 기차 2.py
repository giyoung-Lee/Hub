result = 0
now = 0
for i in range(10):
    minus, add = map(int, input().split())
    now += add
    now -= minus
    result = max(result, now)

print(result)
a, b = map(str, input().split())

result = 0

for i in a:
    for j in b:
        result += int(i) * int(j)

print(result)
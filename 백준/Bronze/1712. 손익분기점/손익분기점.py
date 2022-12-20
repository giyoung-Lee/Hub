a, b, c = map(int, input().split())
i = 0

if c - b <= 0:
    i = -1
else:
    i = (a/(c-b)) + 1

print(int(i))

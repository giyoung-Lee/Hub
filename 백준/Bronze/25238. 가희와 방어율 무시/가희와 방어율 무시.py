a, b = map(int, input().split())

result = a - (a * (b*0.01))

if result >= 100:
    print(0)
else:
    print(1)
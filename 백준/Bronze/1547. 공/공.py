n = int(input())

temp = {"1":1, "2":0, "3":0}

for i in range(n):
    a, b = map(str, input().split())

    now = temp[a]
    temp[a] = temp[b]
    temp[b] = now

if temp["1"] == 1:
    print(1)
elif temp["2"] == 1:
    print(2)
elif temp["3"] == 1:
    print(3)
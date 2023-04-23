st = input()

now = st[0]
result = 10

if len(st) == 1:
    print(result)
else:
    for i in range(1, len(st)):
        if st[i] == now:
           result += 5
           now = st[i]
        else:
            result += 10
            now = st[i]

    print(result)
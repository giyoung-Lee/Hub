n = int(input())
arr = []

for i in range(n):
    a, b = input().split()

    if b == 'enter':
        arr.append(a)
    elif b == 'leave':
        if a in arr:
            arr.remove(a)

arr.sort(reverse=True)

for i in arr:
    print(i)
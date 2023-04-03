n, m = map(int, input().split())

arr = [0]
i = 1

while len(arr) < 1000:
    for j in range(i):
        arr.append(i)

    i += 1

print(sum(arr[n:m+1]))
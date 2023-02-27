n = int(input())
arr = []
result = []

for i in range(n):
    x, y = map(int, input().split())
    arr.append([x, y])


for i in range(n):
    count = 1
    for j in range(n):
        if i != j:
            if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
                count += 1
    result.append(count)

for i in result:
    print(i, end=' ')


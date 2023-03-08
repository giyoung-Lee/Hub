t = int(input())
arr = []

for i in range(t):
    arr.append(int(input()))

arr.sort(reverse=True)

tmp = []
result = 0

if len(arr) < 3:
    print(sum(arr))
else:
    for i in range(len(arr)):

        tmp.append(arr[i])

        if i % 3 == 2:
            result += sum(tmp) - min(tmp)
            tmp = []
        elif i+1 == len(arr):
            result += sum(tmp)

    print(result)


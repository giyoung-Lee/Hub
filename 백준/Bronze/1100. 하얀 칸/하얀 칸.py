result = 0

for i in range(1, 9):
    if i % 2 == 1:
        arr = list(map(str, input().strip()))
        for j in range(len(arr)):
            if (j+1) % 2 == 1 and arr[j] == "F":
                result += 1
    else:
        arr = list(map(str, input().strip()))
        for j in range(len(arr)):
            if (j+1) % 2 == 0 and arr[j] == "F":
                result += 1

print(result)
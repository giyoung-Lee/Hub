arr = []

for i in range(9):
    arr.append(int(input()))

index = 0
result = 0

for i in range(len(arr)):
    if result <= arr[i]:
        result = arr[i]
        index = i

print(result)
print(index+1)
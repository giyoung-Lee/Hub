N = int(input())

arr = []

for i in range(N):
    x = int(input())
    arr.append(x)

arr.sort(reverse=True)

result = []

for i in range(N):
    result.append(arr[i]*(i+1))

print(max(result))
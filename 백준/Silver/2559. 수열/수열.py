a, b = map(int, input().split())
arr = list(map(int, input().split()))
result = [0] * (a+1)

for i in range(1, len(result)):
    result[i] = result[i-1] + arr[i-1]

temp = result[b]
for i in range(b, len(result)):
    temp = max(temp, (result[i] - result[i-b]))

print(temp)
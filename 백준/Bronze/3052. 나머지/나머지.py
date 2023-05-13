arr = []
for i in range(10):
    a = int(input())
    arr.append(a)

result = [0] * 43

for i in range(len(arr)):
    tmp = arr[i] % 42
    result[tmp] += 1


answer = 0
for i in result:
    if i != 0:
        answer += 1

print(answer)
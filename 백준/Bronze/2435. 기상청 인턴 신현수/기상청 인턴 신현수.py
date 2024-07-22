k, n = map(int, input().split())

a = list(map(int, input().split()))
result = -100

for i in range(len(a)-n+1):

    temp = 0
    for j in range(i, i+n):
        temp += a[j]

    if temp > result:
        result = temp

print(result)
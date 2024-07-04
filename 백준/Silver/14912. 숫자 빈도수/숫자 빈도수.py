N, M = map(int, input().split())

result = 0

for i in range(1, N+1):
    for j in str(i):
        if j == str(M):
            result += 1

print(result)
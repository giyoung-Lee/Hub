n = int(input())
count = [float('inf')] * (n + 1)
count[0] = 0

for i in range(3, n+1):
    count[i] = min(count[i-3], count[i-5]) + 1

if count[n] == float('inf'):
    print(-1)
else:
    print(count[n])

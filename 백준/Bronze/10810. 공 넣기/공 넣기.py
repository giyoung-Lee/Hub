n, m = map(int, input().split())

dic = dict()
for i in range(1, n+1):
    dic[i] = 0

for _ in range(m):
    i, j, k = map(int, input().split())

    for t in range(i, j+1):
        dic[t] = k

for i in range(1, len(dic)+1):
    print(dic[i], end=' ')
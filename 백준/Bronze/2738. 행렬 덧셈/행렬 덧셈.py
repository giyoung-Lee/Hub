N, M = map(int,input().split())
a = []
for i in range(N):
    a.append(list(map(int,input().split())))
b = []
for i in range(N):
    b.append(list(map(int,input().split())))
ans = []
for i in range(N):
    ans.append([0]*M)
for i in range(N):
    for j in range(M):
        ans[i][j] = a[i][j] + b[i][j]
for i in range(N):
    print(*ans[i])
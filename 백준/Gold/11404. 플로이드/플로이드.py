import sys
INF = sys.maxsize

n = int(input())
m = int(input())

fd = [[INF] * (n+1) for i in range(n+1)]

for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            fd[a][b] = 0


for i in range(m):
    a, b, c = map(int, input().split())
    fd[a][b] = min(fd[a][b], c)


for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            fd[i][j] = min(fd[i][j], fd[i][k] + fd[k][j])


for i in range(1, n+1):
    for j in range(1, n+1):
        if fd[i][j] == INF:
            print(0, end=' ')
        else:
            print(fd[i][j], end=' ')
    print()
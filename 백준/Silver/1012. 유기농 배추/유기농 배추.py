import sys
sys.setrecursionlimit(10000)

T = int(input())

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def dfs(x, y):
    ch[x][y] = 1
    for _ in range(4):
        xx, yy = x + dx[_], y + dy[_]
        if arr[xx][yy] == 0 or ch[xx][yy]:
            continue
        dfs(xx,yy)


for i in range(T):
    arr, ch = [], []
    M, N, K = map(int, input().split())
    arr = [[0 for i in range(M+2)] for _ in range(N+2)]
    ch = [[0 for i in range(M+2)] for _ in range(N+2)]

    for _ in range(K):
        x, y = map(int, input().split())
        arr[y+1][x+1] = 1
    

    ans = 0
    for i in range(1, N+1):
        for j in range(1, M+1):
            if arr[i][j] == 0 or ch[i][j]:
                continue
            dfs(i, j)
            ans += 1
    print(ans)



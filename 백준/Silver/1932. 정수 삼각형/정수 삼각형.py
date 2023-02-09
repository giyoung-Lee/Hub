n = int(input())

T = [[0 for i in range(n+1)] for _ in range(n+1)]
dp = [[0 for i in range(n+1)] for _ in range(n+1)]


for i in range(1, n+1):
    tmp = list(map(int, input().split()))
    for j in range(1, i+1):
        T[i][j] = tmp[j-1]


for i in range(1, n+1):
    for j in range(1, i+1):
        dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + T[i][j]


print(max(dp[-1]))
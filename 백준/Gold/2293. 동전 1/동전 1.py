n, k = map(int, input().split())
arr = [int(input()) for i in range(n)]

dp = [0] * (k+1)
dp[0] = 1

for i in arr:
    for j in range(i, k+1):
        if j-i >= 0:
            dp[j] += dp[j-i]

print(dp[k])
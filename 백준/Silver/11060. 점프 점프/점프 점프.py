n = int(input())
arr = list(map(int, input().split(" ")))
dp = [1001 for _ in range(n)]

dp[0] = 0

for i in range(n):
    for j in range(1, arr[i]+1):
        if i+j > n-1:
            break
        dp[i+j] = min(dp[i]+1, dp[i+j])

if dp[-1] == 1001:
    print(-1)
else:
    print(dp[-1])
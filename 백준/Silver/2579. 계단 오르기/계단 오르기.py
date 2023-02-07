n = int(input())
arr = [0]

for i in range(n):
    arr.append(int(input()))

dp = [0] * (n+1)
dp[1] = arr[1]

for i in range(2, n+1):
        dp[i] = max(arr[i] + dp[i-2], arr[i] + arr[i-1] + dp[i-3])

print(dp[n])
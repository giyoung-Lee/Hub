n = int(input())
T = []
P = []

for i in range(n):
    a, b = map(int, input().split())
    T.append(a)
    P.append(b)


dp = [0 for i in range(n+1)]

for i in range(n):
    time = T[i]
    profit = P[i]

    if i + time <= n:
        dp[i + time] = max(dp[i + time], dp[i] + profit)
    dp[i + 1] = max(dp[i + 1], dp[i])

print(dp[n])
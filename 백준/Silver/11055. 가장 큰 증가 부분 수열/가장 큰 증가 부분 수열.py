import copy
n = int(input())

A = list(map(int, input().split()))

# DP[i] : i 까지 왔을때, 합의 최대
DP = copy.deepcopy(A)

for i in range(1, n):
    for j in range(i):
        if A[i] > A[j]:
            DP[i] = max(A[i]+DP[j], DP[i])

print(max(DP))
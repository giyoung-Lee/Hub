from itertools import permutations

n = int(input())
a = list(map(int, input().split()))

max_val = -1
for perm in permutations(a):
    val = 0
    for i in range(n-1):
        val += abs(perm[i] - perm[i+1])
    max_val = max(max_val, val)

print(max_val)
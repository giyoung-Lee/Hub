n, m, k = map(int, input().split())

result = 0

for _ in range(n):
    arr = input().strip()
    count_zeros = arr[:k].count('0')

    if count_zeros == k:
        result += 1

    for i in range(1, m - k + 1):
        if arr[i - 1] == '0':
            count_zeros -= 1
        if arr[i + k - 1] == '0':
            count_zeros += 1

        if count_zeros == k:
            result += 1

print(result)
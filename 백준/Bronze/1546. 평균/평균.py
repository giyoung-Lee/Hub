n = int(input())

arr = list(map(int, input().split()))

high = max(arr)

total = 0
for i in arr:
    total += (i / high) * 100

total /= n

print(total)
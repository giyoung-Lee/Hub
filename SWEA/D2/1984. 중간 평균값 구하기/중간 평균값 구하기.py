T = int(input())

for test_case in range(1, T+1):
    arr = list(map(int, input().split()))

    tmp = sum(arr) - min(arr) - max(arr)

    result = round(tmp / 8)

    print(f"#{test_case} {result}")

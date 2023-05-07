T = int(input())


for test_case in range(1, T+1):
    ans = 0

    n = int(input())
    arr = list(map(int, input().split()))
    average = sum(arr) / len(arr)

    for i in arr:
        if i <= average:
            ans += 1


    print(f"#{test_case} {ans}")



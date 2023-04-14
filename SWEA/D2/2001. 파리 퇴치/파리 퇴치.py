T = int(input())

for test_case in range(1, T+1):
    n, m = map(int, input().split())

    arr = [list(map(int, input().split())) for _ in range(n)]

    result = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
            tmp = 0
            for a in range(i, i+m):
                for b in range(j, j+m):
                    tmp += arr[a][b]

            result = max(result, tmp)

    print(f"#{test_case} {result}")
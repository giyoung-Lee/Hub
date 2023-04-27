T = int(input())

for test_case in range(1, T+1):
    n = int(input())

    answer = 0
    now_v = 0

    for i in range(n):
        arr = list(map(int, input().split()))

        if arr[0] == 1:
            now_v += arr[1]
            answer += now_v
        elif arr[0] == 0:
            answer += now_v
        elif arr[0] == 2:
            now_v -= arr[1]
            if now_v < 0:
                now_v = 0
            answer += now_v

    print(f"#{test_case} {answer}")





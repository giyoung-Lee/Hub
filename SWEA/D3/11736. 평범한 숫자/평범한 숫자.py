T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    arr = list(map(int, input().split()))

    answer = 0

    for i in range(1, len(arr)-1):
        min_v = min(arr[i-1], arr[i], arr[i+1])
        max_v = max(arr[i-1], arr[i], arr[i+1])
        if arr[i] != min_v and arr[i] != max_v:
            answer += 1

    print(f"#{test_case} {answer}")

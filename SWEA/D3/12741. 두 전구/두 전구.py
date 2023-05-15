T = int(input())

result = []
for test_case in range(1, T+1):
    arr = list(map(int, input().split()))
    answer = 0

    min_v = min(arr)
    max_v = max(arr)

    for i in range(min_v, max_v):
        tmp = 0
        if arr[0] <= i < arr[1]:
            tmp += 1

        if arr[2] <= i < arr[3]:
            tmp += 1

        if tmp == 2:
            answer += 1
    result.append((test_case, answer))

for a, b in result:
    print(f'#{a} {b}')

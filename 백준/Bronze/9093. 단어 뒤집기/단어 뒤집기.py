T = int(input())

for test_case in range(1, T+1):
    arr = list(map(str, input().split()))

    result = []
    for i in arr:
        tmp = ''
        for j in reversed(i):
            tmp += j

        result.append(tmp)

    for i in result:
        print(i, end=' ')
T = int(input())

for test_case in range(1, T+1):
    arr = []
    n = int(input())
    count = 0

    for i in range(n):
        a, b = map(str, input().split())
        arr.append([a, int(b)])
        count += int(b)

    tmp = ''

    for i in range(len(arr)):
        for j in range(arr[i][1]):
            tmp += arr[i][0]

    tmp2 = ''
    print(f"#{test_case}")

    for i in range(len(tmp)):
        if len(tmp2) < 10:
            tmp2 += tmp[i]
        else:
            print(tmp2)
            tmp2 = ''
            tmp2 += tmp[i]

    if tmp2 != '':
        print(tmp2)

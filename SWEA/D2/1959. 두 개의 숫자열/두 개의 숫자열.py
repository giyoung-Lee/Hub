T = int(input())

for test_case in range(1, T+1):
    len_a, len_b = map(int, input().split())

    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    result = 0
    if len_a == len_b:
        for i in range(len_a):
            result += a[i] * b[i]

    elif len_a > len_b:
        len_tmp = len_a - len_b
        for i in range(len_tmp+1):
            tmp = 0
            for j in range(len_b):
                tmp += a[j+i] * b[j]

            result = max(result, tmp)

    elif len_b > len_a:
        len_tmp = len_b - len_a
        for i in range(len_tmp+1):
            tmp = 0
            for j in range(len_a):
                tmp += b[j+i] * a[j]

            result = max(result, tmp)

    print(f"#{test_case} {result}")
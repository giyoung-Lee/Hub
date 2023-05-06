T = int(input())


for test_case in range(1, T+1):
    ans = ''
    n, m = map(int, input().split())
    binary = str(bin(m)[2:])
    length = len(binary) - n

    if len(binary) >= n:
        tmp = 0
        for i in binary[length:]:
            if i == '1':
                tmp += 1

        if tmp == n:
            ans = 'ON'
        else:
            ans = 'OFF'
    else:
        ans = 'OFF'

    print(f"#{test_case} {ans}")



T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    arr = {2:0, 3:0, 5:0, 7:0, 11:0}

    while n % 2 == 0:
        n /= 2
        arr[2] += 1

    while n % 3 == 0:
        n /= 3
        arr[3] += 1

    while n % 5 == 0:
        n /= 5
        arr[5] += 1

    while n % 7 == 0:
        n /= 7
        arr[7] += 1

    while n % 11 == 0:
        n /= 11
        arr[11] += 1

    print(f"#{test_case} {arr[2]} {arr[3]} {arr[5]} {arr[7]} {arr[11]}")





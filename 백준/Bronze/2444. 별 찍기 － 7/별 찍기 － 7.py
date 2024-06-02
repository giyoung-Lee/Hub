N = int(input())

for i in range(N):
    # 공백 출력
    for j in range(N - i - 1):
        print(' ', end='')
    # 별 출력
    for k in range(2 * i + 1):
        print('*', end='')
    print()

for i in range(N - 2, -1, -1):
    # 공백 출력
    for j in range(N - i - 1):
        print(' ', end='')
    # 별 출력
    for k in range(2 * i + 1):
        print('*', end='')
    print()
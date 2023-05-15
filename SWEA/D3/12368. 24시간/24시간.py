T = int(input())


for test_case in range(1, T+1):
    a, b = map(int, input().split())
    answer = 0

    answer = (a+b) % 24

    print(f'#{test_case} {answer}')

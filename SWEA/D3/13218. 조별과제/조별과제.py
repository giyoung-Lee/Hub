from itertools import combinations
T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    answer = n//3

    print(f'#{test_case} {answer}')

T = int(input())  # 테스트 케이스의 수

for test_case in range(1, T+1):
    N = int(input())  # 반지름 N
    count = 0  # 격자점 개수를 저장할 변수

    for x in range(-N, N + 1):
        for y in range(-N, N + 1):
            if (x ** 2 + y ** 2) <= N ** 2:
                count += 1

    print(f"#{test_case} {count}")
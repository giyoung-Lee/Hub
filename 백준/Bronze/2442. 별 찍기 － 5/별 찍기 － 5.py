# 입력 받기
N = int(input())

# 각 줄을 순서대로 출력
for i in range(1, N + 1):
    # 공백의 개수: N - i
    # 별의 개수: 2 * i - 1
    print(' ' * (N - i) + '*' * (2 * i - 1))
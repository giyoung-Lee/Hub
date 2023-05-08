T = int(input())  # 테스트 케이스 수 입력 받기

for i in range(1, T+1):
    N, A, B = map(int, input().split())

    # P채널과 T채널 모두 구독하는 사람의 수
    both = min(A, B)

    # P채널과 T채널을 합쳐 구독하는 사람의 수
    total = A + B

    min_both = max(0, total - N)
    max_both = min(both, N)

    # 출력
    print(f"#{i} {max_both} {min_both}")

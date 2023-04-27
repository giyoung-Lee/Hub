T = int(input())

for test_case in range(1, T+1):
    A_P, B_Q, B_R, B_S, W = map(int, input().split())

    A_com = A_P * W
    if W <= B_R:
        B_com = B_Q
    else:
        B_com = B_Q + (W - B_R) * B_S

    answer = min(A_com, B_com)

    print(f"#{test_case} {answer}")




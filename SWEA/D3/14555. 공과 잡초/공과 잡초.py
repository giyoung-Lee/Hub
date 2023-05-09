T = int(input())  # 테스트 케이스 수 입력 받기

for test_case in range(1, T+1):
    st = input()
    result = 0

    for i in range(len(st)-1):
        if st[i] == '(' and (st[i+1] == '|' or st[i+1] == ')'):
            result += 1
        elif st[i] == '|' and st[i+1] == ')':
            result += 1


    # 출력
    print(f"#{test_case} {result}")

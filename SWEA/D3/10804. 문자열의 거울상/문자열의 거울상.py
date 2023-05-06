T = int(input())

for test_case in range(1, T+1):
    st = input()
    tmp = st[::-1]
    ans = ''
    for i in tmp:
        if i == 'q':
            ans += 'p'
        elif i == 'p':
            ans += 'q'
        elif i == 'b':
            ans += 'd'
        elif i == 'd':
            ans += 'b'

    print(f"#{test_case} {ans}")

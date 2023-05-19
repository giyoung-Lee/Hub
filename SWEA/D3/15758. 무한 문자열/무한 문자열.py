T = int(input())

for test_case in range(1, T+1):
    a, b = map(str, input().split())
    answer = ''
    if len(a) == len(b):
        if a == b:
            answer = 'yes'
        else:
            answer = 'no'

    else:
        a_len, b_len = len(a), len(b)
        a = a * b_len
        b = b * a_len
        if a == b:
            answer = 'yes'
        else:
            answer = 'no'

    print(f"#{test_case} {answer}")

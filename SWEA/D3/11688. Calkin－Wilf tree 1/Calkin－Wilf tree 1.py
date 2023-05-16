T = int(input())

for test_case in range(1, T+1):
    arr = list(map(str, input()))
    a, b = 1, 1
    for i in arr:
        if i == 'L':
            b = a+b
        elif i == 'R':
            a = a+b

    print(f"#{test_case} {a} {b}")

T = int(input())

for test_case in range(1, T+1):
    st = input()

    tmp = int(len(st)/2)
    count = 0

    for i in range(tmp):
        tc = -i
        if st[i] == st[tc-1]:
            count += 1

    if count == tmp:
        print(f"#{test_case} 1")
    else:
        print(f"#{test_case} 0")


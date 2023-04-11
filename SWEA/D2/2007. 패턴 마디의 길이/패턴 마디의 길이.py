T = int(input())

for test_case in range(1, T+1):
    st = input()
    count = 1
    tmp = str(st[0])

    while True:

        if tmp == st[count:count+len(tmp)]:
            break
        else:
            tmp += str(st[count])
            count += 1

    print(f"#{test_case} {int(len(tmp))}")
T = int(input())


def solve(word):
    tmp = word[::-1]
    if tmp == word:
        return 2
    else:
        return 1


for test_case in range(1, T+1):
    n, m = map(int, input().split())
    ans = 0
    for i in range(n, m+1):
        tmp = 0
        st1, st2 = str(i), (i**(1/2))
        if st2.is_integer():
            tmp += solve(str(int(st2)))


        tmp += solve(st1)

        if tmp == 4:
            ans += 1

    print(f"#{test_case} {ans}")



T = 10

for test_case in range(1, T+1):
    n = int(input())
    st = input()
    st2 = input()
    result = st2.count(st)

    print(f"#{n} {result}")

T = int(input())

for test_case in range(1, T+1):
    n = int(input())

    print(f"#{test_case}", end=' ')
    for i in range(n):
        print(f"1/{n}", end=' ')
    print()
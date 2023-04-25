T = int(input())

date = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}

for test_case in range(1, T+1):
    mon_a, day_a, mon_b, day_b = map(int, input().split())

    result = 0

    for i in range(mon_a, mon_b):
        if mon_a == i:
            result += date[i] - day_a + 1
        else:
            result += date[i]

    result += day_b

    print(f"#{test_case} {result}")

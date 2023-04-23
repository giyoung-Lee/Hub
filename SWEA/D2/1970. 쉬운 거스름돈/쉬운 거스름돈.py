T = int(input())

for test_case in range(1, T+1):
    money = {50000: 0, 10000: 0, 5000: 0, 1000: 0, 500: 0, 100: 0, 50: 0, 10: 0}

    n = int(input())
    while True:
        if n < 10:
            break

        if n >= 50000:
            money[50000] += n//50000
            n %= 50000
        elif n >= 10000:
            money[10000] += n//10000
            n %= 10000
        elif n >= 5000:
            money[5000] += n//5000
            n %= 5000
        elif n >= 1000:
            money[1000] += n//1000
            n %= 1000
        elif n >= 500:
            money[500] += n//500
            n %= 500
        elif n >= 100:
            money[100] += n//100
            n %= 100
        elif n >= 50:
            money[50] += n//50
            n %= 50
        elif n >= 10:
            money[10] += n//10
            break

    print(f"#{test_case}")
    print(f"{money[50000]} {money[10000]} {money[5000]} {money[1000]} {money[500]} {money[100]} {money[50]} {money[10]}")
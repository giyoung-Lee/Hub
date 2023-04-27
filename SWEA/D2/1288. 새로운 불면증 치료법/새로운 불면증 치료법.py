T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    answer = 0

    dic = {0: 0, 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 0, 9: 0}
    for i in str(n):
        dic[int(i)] += 1

    now = n
    while True:
        if dic[0] > 0 and dic[1] > 0 and dic[2] > 0 and dic[3] > 0 and dic[4] > 0 and dic[5] > 0 and dic[6] > 0 and dic[7] > 0 and dic[8] > 0 and dic[9] > 0:
            break

        answer += 1
        now += n
        for i in str(now):
            dic[int(i)] += 1

    print(f"#{test_case} {now}")





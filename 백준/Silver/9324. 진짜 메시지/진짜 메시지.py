from string import ascii_uppercase

n = int(input())
dic = {}

for i in range(n):
    st = input()
    result = ""

    for _ in ascii_uppercase:
        dic[_] = 0

    flag = False

    for j in st:
        if flag:
            flag = False
            continue
        dic[j] += 1
        if dic[j]%3 == 0 and dic[j] != 0:
            result += j
            result += j
            flag = True
        else:
            result += j


    if result == st:
        print("OK")
    else:
        print("FAKE")
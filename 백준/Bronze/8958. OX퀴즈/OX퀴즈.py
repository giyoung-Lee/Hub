n = int(input())

for _ in range(n):
    st = input()
    count = 1
    result = 0
    flag = False

    for i in st:
        if flag:
            if i == "O":
                count += 1
                result += count
            else:
                count = 1
                flag = False
        else:
            if i == "O":
                result += 1
                flag = True

    print(result)
while True:
    n = int(input())
    if n == 0:
        exit()

    arr = []
    mv = 0
    for i in range(n):
        temp = list(input().split())
        arr.append([temp[0], float(temp[1])])

        if float(temp[1]) > mv:
            mv = float(temp[1])

    for i in arr:
        if i[1] == mv:
            print(i[0], end=" ")
    print()
while True:
    n = input()
    if n == "0":
        break

    result = 1
    for i in n:
        if i == "1":
            result += 3
        elif i == "0":
            result += 5
        else:
            result += 4

    print(result)
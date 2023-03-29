while True:
    n = input()
    if n == "0":
        break

    tmp = n[::-1]
    if tmp == n:
        print("yes")
    else:
        print("no")
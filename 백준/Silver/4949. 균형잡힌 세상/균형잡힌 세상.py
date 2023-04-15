while True:
    st = input()
    if st == ".":
        break

    arr = []
    flag = True

    for i in st:
        if i == "(":
            arr.append(i)
        elif i == ")":
            if len(arr) != 0:
                tmp = arr.pop()
                if tmp != "(":
                    print("no")
                    flag = False
                    break
            else:
                print("no")
                flag = False
                break

        elif i == "[":
            arr.append(i)
        elif i == "]":
            if len(arr) != 0:
                tmp = arr.pop()
                if tmp != "[":
                    print("no")
                    flag = False
                    break
            else:
                print("no")
                flag = False
                break

    if len(arr) == 0 and flag:
        print("yes")
    elif len(arr) != 0 and flag:
        print("no")



while True:
    password = input()

    if password == "end":
        exit()

    flag = 0
    for _ in password:
        if _ == "a" or _ == "e" or _ == "i" or _ == "o" or _ == "u":
            flag += 1

    if flag == 0:
        print("<"+password+"> is not acceptable.")
        continue

    mo = 0
    ja = 0
    temp = True

    for index, i in enumerate(password):
        if index != len(password)-1:
            if password[index+1] == i:
                if i + password[index+1] != "ee" and i + password[index+1] != "oo":
                    print("<"+password+"> is not acceptable.")
                    flag = False
                    continue

        if i == "a" or i == "e" or i == "i" or i == "o" or i == "u":
            mo += 1
            ja = 0
        else:
            ja += 1
            mo = 0

        if mo == 3 or ja == 3:
            print("<"+password+"> is not acceptable.")
            flag = False
            continue

    if flag:
        print("<"+password+"> is acceptable.")
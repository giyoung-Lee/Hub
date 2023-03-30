while True:
    n = input()
    if n == "#":
        break

    result = 0

    for i in n:
        if i == "a" or i == "i" or i == "u" or i == "e" or i == "o":
            result += 1
        elif i == "A" or i == "I" or i == "U" or i == "E" or i == "O":
            result += 1

    print(result)
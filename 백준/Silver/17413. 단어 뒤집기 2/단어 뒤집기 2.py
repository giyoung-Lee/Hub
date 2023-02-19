arr = input()
tag = False
tmp = ''

for i in arr:
    if i == ' ':
        if not tag:
            print(tmp[::-1], end=" ")
            tmp = ""
        else:
            print(" ", end="")

    elif i == '<':
        tag = True
        print(tmp[::-1] + "<", end="")
        tmp = ""

    elif i == '>':
        tag = False
        print(">", end="")
    
    else:
        if tag:
            print(i, end="")
        else:
            tmp += i

print(tmp[::-1])

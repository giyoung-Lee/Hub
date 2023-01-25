arr = []


for i in range(int(input())):
    result = True
    size = 0

    tmp = str(input())
    arr = list(tmp)

    while True:
        size += 1
        if len(arr) > 1:
            if arr[0] == arr[-1]:
                arr = arr[1:-1]

            else:
                result = False
                break
        else:
            break

    arr = []
    tmp = ""

    if result:
        print("1", size)
    else:
        print("0", size)

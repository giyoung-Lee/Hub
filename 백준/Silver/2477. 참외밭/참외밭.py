from collections import deque

N = int(input())

arr = deque()
count_dict = {1:0, 2:0, 3:0, 4:0}
max_row = 0
max_col = 0

for i in range(6):
    a, b = map(int, input().split())
    arr.append([a, b])
    count_dict[a] += 1

    if a == 1 or a == 2:
        if b > max_row:
            max_row = b

    if a == 3 or a == 4:
        if b > max_col:
            max_col = b

# -|
if count_dict[1] == 2 and count_dict[2] == 1 and count_dict[3] == 2 and count_dict[4] == 1:
    flag = True
    while flag:

        temp = []
        for i in arr:
            temp.append(i[0])

        if temp == [2, 3, 1, 3, 1, 4]:
            flag = False
        else:
            arr.rotate(-1)

    print(((arr[1][1] * arr[2][1]) + (arr[4][1] * arr[5][1])) * N)

# |-
elif count_dict[1] == 2 and count_dict[2] == 1 and count_dict[3] == 1 and count_dict[4] == 2:
    flag = True
    while flag:

        temp = []
        for i in arr:
            temp.append(i[0])

        if temp == [2, 3, 1, 4, 1, 4]:
            flag = False
        else:
            arr.rotate()

    print(((arr[1][1] * arr[2][1]) + (arr[4][1] * arr[5][1])) * N)
# |_
elif count_dict[1] == 1 and count_dict[2] == 2 and count_dict[3] == 1 and count_dict[4] == 2:
    flag = True
    while flag:

        temp = []
        for i in arr:
            temp.append(i[0])

        if temp == [2, 4, 2, 3, 1, 4]:
            flag = False
        else:
            arr.rotate()

    print(((arr[0][1] * arr[5][1]) + (arr[2][1] * arr[3][1])) * N)

# _|
elif count_dict[1] == 1 and count_dict[2] == 2 and count_dict[3] == 2 and count_dict[4] == 1:
    flag = True
    while flag:

        temp = []
        for i in arr:
            temp.append(i[0])

        if temp == [2, 3, 2, 3, 1, 4]:
            flag = False
        else:
            arr.rotate()

    print(((arr[0][1] * arr[5][1]) + (arr[2][1] * arr[3][1])) * N)
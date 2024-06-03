list1 = list(map(int, input().split()))
list2 = list(map(int, input().split()))
list3 = list(map(int, input().split()))


def print_number(front, back):
    if back == 3 and front == 1:
        print("A")
    elif back == 2 and front == 2:
        print("B")
    elif back == 1 and front == 3:
        print("C")
    elif back == 0 and front == 4:
        print("D")
    elif back == 4 and front == 0:
        print("E")


front = 0
back = 0
for i in list1:
    if i == 1:
        back += 1
    else:
        front += 1
print_number(front, back)

front = 0
back = 0
for i in list2:
    if i == 1:
        back += 1
    else:
        front += 1
print_number(front, back)


front = 0
back = 0
for i in list3:
    if i == 1:
        back += 1
    else:
        front += 1
print_number(front, back)
st = input()

arr = [1, 0, 0]

for i in st:
    if i == "A":
        arr[0], arr[1] = arr[1], arr[0]
    elif i == "B":
        arr[1], arr[2] = arr[2], arr[1]
    elif i == "C":
        arr[2], arr[0] = arr[0], arr[2]

for index, i in enumerate(arr):
    if i == 1:
        print(index+1)
        break
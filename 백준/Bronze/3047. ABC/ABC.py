arr = list(map(int, input().split()))
st = input()

arr.sort()
for i in st:
    if i != st[-1]:
        if i == "A":
            print(arr[0], end=" ")
        elif i == "B":
            print(arr[1], end=" ")
        else:
            print(arr[2], end=" ")
    else:
        if i == "A":
            print(arr[0], end="")
        elif i == "B":
            print(arr[1], end="")
        else:
            print(arr[2], end="")
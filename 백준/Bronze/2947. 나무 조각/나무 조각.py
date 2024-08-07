arr = list(map(int, input().split()))

flag = True

while flag:
    for i in range(len(arr)-1):
        if arr[i] > arr[i+1]:
            temp = arr[i]
            arr[i] = arr[i+1]
            arr[i+1] = temp

            for j in arr:
                print(j, end=' ')
            print()

    count = 0
    for index, i in enumerate(arr):
        if index+1 == i:
            count += 1

    if count == 5:
        flag = False
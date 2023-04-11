T = int(input())

for test_case in range(1, T+1):
    arr = []
    n = int(input())

    for i in range(n):
        arr.append([])
        arr[i].append(1)
        for j in range(1, i):
            arr[i].append(arr[i-1][j-1] + arr[i-1][j])

        if i != 0:
            arr[i].append(1)

    print(f"#{test_case}")
    for i in arr:
        for j in i:
            print(j, end=' ')
        print()

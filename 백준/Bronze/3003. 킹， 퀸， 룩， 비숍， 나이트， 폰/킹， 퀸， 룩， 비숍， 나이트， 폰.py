arr = list(map(int, input().split()))
result = []

for i in ["k", "q", "l", "b", "n", "p"]:
    if i == "k":
        result.append(1 - arr[0])
    elif i == "q":
        result.append(1 - arr[1])
    elif i == "l":
        result.append(2 - arr[2])
    elif i == "b":
        result.append(2 - arr[3])
    elif i == "n":
        result.append(2 - arr[4])
    elif i == "p":
        result.append(8 - arr[5])

for i in result:
    print(i, end=' ')
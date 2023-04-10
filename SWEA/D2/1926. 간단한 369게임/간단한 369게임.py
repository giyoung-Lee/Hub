n = int(input())

for i in range(1, n+1):
    tmp = str(i)
    count = 0
    for j in tmp:
        if "3" == j or "6" == j or "9" == j:
            count += 1

    if count >= 1:
        print("-"*count, end=' ')

    else:
        print(i, end=' ')
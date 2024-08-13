n = int(input())

while True:
    temp = int(input())

    if temp == 0:
        break

    if temp % n == 0:
        print(f"{temp} is a multiple of {n}.")
    else:
        print(f"{temp} is NOT a multiple of {n}.")
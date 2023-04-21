while True:
    st = input()

    if st == "END":
        break

    for i in reversed(st):
        print(i, end='')
    print()
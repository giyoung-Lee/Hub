t = int(input())

for i in range(t):
    st = input()

    if len(st) == 1:
        st += st
        print(st)
    else:
        print(st[0]+st[-1])
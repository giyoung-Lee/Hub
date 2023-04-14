n = int(input())

for _ in range(n):
    st = input()

    if len(st) % 2 == 1:
        print("NO")

    elif st[0] == ")":
        print("NO")

    elif st[-1] == "(":
        print("NO")

    else:
        left = 0
        flag = True
        for i in st:
            if left < 0:
                print("NO")
                flag = False
                break
            else:
                if i == "(":
                    left += 1
                elif i == ")":
                    left -= 1
        if left == 0:
            print("YES")
        elif left < 0 and flag:
            print("NO")
        elif left > 0 and flag:
            print("NO")

n = int(input())

pattern = input()
front, back = pattern.split('*')

for _ in range(n):
    filename = input()

    if len(filename) < len(front) + len(back):
        print("NE")
    else:
        if filename[:len(front)] == front and filename[-len(back):] == back:
            print("DA")
        else:
            print("NE")
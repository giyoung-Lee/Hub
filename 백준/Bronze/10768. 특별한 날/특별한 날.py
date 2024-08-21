h = input()
m = input()

if len(m) == 1:
    m += "0"

result = int(h + m)

if result == 218:
    print("Special")
elif result < 218:
    print("Before")
elif result > 218:
    print("After")
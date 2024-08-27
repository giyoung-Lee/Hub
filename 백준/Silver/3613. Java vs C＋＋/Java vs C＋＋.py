st = input()
temp = ""

if st[0] == "_" or st[0].isupper() or st[-1] == "_":
    print("Error!")
    exit()

if len(st) == 1:
    print(st)
    exit()

if "_" in st:

    for i in st:
        if i.isupper():
            print("Error!")
            exit()

    count = 0
    for i in st:
        if count >= 2:
            print("Error!")
            exit()

        if i == "_":
            count += 1
        else:
            count = 0

    arr = st.split("_")

    for index, i in enumerate(arr):
        if index != 0:
            trans = i[0].upper() + i[1:]
            temp += trans
        else:
            temp += i

else:
    for i in st:
        if i.isupper():
            temp += "_"+i.lower()
        else:
            temp += i


print(temp)
n = int(input())
flag = 0

for i in range(n):
    st = input()

    if st == 'anj':
        flag += 1
        break

if flag == 1:
    print("뭐야;")
else:
    print("뭐야?")
n = int(input())
list_ = list(map(int, input().split()))

temp = {}
for i in list_:
    if i not in temp:
        temp[i] = 1
    else:
        temp[i] += 1

k = int(input())

list2 = list(map(int, input().split()))

for i in list2:
    if i not in temp:
        print(0, end=" ")
    else:
        print(temp[i], end=" ")
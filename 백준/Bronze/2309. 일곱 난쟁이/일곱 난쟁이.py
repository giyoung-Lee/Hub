from itertools import combinations

arr = []

for i in range(9):
    arr.append(int(input()))

arr.sort()
tmp = []

for i in combinations(arr, 7):
    if sum(i) == 100:
        tmp.append(list(i))
        break

for i in tmp[0]:
    print(i)

_list = []
max_num = 0
max_i, max_j = 0, 0

for i in range(9):
    _list.append(list(map(int, input().split())))

for i in range(9):
    for j in range(9):
        if _list[i][j] > max_num:
            max_num = _list[i][j]
            max_i = i
            max_j = j

print(max_num)
print(max_i+1, max_j+1)
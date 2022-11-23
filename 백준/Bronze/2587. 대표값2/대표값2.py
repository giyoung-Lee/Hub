_list = []

for _ in range(5):
    _list.append(int(input()))

_list.sort()

print(int(sum(_list)/5))
print(_list[2])
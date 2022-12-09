from collections import Counter


def mode(n):
    order = Counter(n).most_common()

    _max = order[0][1]
    modes = []

    for num in order:
        if num[1] == _max:
            modes.append(num[0])

    if len(modes) >= 2:
        return modes[1]
    else:
        return order[0][0]


n = int(input())

_list = []

for _ in range(n):
    _list.append(int(input()))

_list.sort()
print(int(round(sum(_list) / n)))
print(_list[int(n / 2)])
print(mode(_list))
print(max(_list) - min(_list))

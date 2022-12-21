n = int(input())
_list = []

for i in range(n):
    _list.append(input())

_list = list(set(_list))
_list.sort()
_list.sort(key=lambda x: len(x))

for i in _list:
    print(i)
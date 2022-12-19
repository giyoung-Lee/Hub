n = int(input())
_list = []

for _ in range(n):
    i, j = map(int, input().split())
    _list.append(i+j)

for i in _list:
    print(i)
n = int(input())
_list = []

for _ in range(n):
    _list.append(int(input()))

_list.sort()
result = 0

for i in range(1, len(_list)+1):
    result += abs(int(_list[i-1])-i)

print(result)
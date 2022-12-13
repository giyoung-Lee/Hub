import sys
input = sys.stdin.readline

n = int(input())
_list = list(map(int, input().split()))
_list2 = list(set(_list))
_list2.sort()

result = {}

for i, x in enumerate(_list2):
    result[x] = i

for x in _list:
    print(result[x], end=' ')
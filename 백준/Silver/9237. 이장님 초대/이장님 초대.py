import sys
input = sys.stdin.readline

n = int(input())
_list = list(map(int, input().split()))

_list.sort(reverse=True)

result = 0
for i in range(n):
    result = max(result, i + 1 + _list[i])

print(result + 1)

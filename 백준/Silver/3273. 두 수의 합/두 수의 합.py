import sys
input = sys.stdin.readline

n = int(input())
_list = list(map(int, input().split()))
m = int(input())

_list.sort()
result = 0
start = 0
end = n -1

while start < end:
    current = _list[start] + _list[end]
    if current == m:
        result += 1
        start += 1
    elif current < m:
        start += 1
    elif current > m:
        end -= 1

print(result)

n = int(input())
_list = list(map(int, input().split()))
_list2 = list(map(int, input().split()))

_list.sort()
_list2.sort(reverse=True)
answer = 0

for i in range(n):
    answer += _list[i] * _list2[i]

print(answer)
n = int(input())
_list = list(map(int, input().split()))
v = int(input())
answer = 0

for i in _list:
    if v == i:
        answer += 1

print(answer)
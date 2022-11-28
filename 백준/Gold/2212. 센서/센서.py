import sys

n = int(input())
k = int(input())
_list = list(map(int, input().split()))

dis_list = []
_list.sort()

if k >= n:
    print(0)
    sys.exit()

for i in range(1, len(_list)):
    dis_list.append(abs(_list[i]-_list[i-1]))

dis_list.sort()

for i in range(k-1):
    dis_list.pop()

print(sum(dis_list))
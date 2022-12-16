import sys
input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    _list = []
    _list = list(map(int, input().split()))
    arr.append((_list[0], _list[1]))

arr.sort(key=lambda x: (x[1], x[0]))

for i in arr:
    print(i[0], i[1])
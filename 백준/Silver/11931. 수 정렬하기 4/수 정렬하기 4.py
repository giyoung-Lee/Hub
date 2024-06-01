import sys

n = int(sys.stdin.readline().strip())
list_ = []

for i in range(n):
    x = int(sys.stdin.readline().strip())
    list_.append(x)

list_.sort(reverse=True)

for i in list_:
    print(i)
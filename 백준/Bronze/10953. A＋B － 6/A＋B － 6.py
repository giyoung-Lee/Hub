n = int(input())

for i in range(n):
    list1 = list(map(int, input().split(",")))
    print(list1[0]+list1[1])
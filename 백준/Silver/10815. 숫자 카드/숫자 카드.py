n = int(input())
set1 = set(map(int, input().split()))

m = int(input())
arr1 = list(map(int, input().split()))

for i in arr1:
    if i in set1:
        print("1", end=' ')
    else:
        print("0", end=' ')
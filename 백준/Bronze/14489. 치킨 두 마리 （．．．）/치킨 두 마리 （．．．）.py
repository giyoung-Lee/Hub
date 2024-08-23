arr = list(map(int, input().split()))
chick = int(input())

if arr[0] + arr[1] < chick * 2:
    print(arr[0] + arr[1])
else:
    print((arr[0] + arr[1]) - chick*2)
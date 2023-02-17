n = int(input())
result = 0
tmp = 0

for i in range(n):
    arr = sorted(list(map(int, input().split())))

    if len(set(arr)) == 1:
        result = arr[0] * 5000 + 50000
    elif len(set(arr)) == 2:
        if arr[1] == arr[2]:
            result = 10000 + arr[1] * 1000
        else:
            result = 2000 + (arr[1]+arr[2]) * 500
    elif len(set(arr)) == 3:
        for i in range(3):
            if arr[i] == arr[i+1]:
                result = 1000 + arr[i] * 100
    else:
        result = arr[-1] * 100
    
    tmp = max(result, tmp) 


print(tmp)
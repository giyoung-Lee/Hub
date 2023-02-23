import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))

start = 0
end = 0
count = 0

while True:
    if start == n-1:
        if arr[start] == k:
            count += 1
        print(count)
        break
    
    tmp = 0

    for i in range(start, end):
        tmp += arr[i]


    if tmp == k:
        if end < n:
            count += 1
            end += 1
            start += 1
        else:
            count += 1
            start += 1

    elif tmp < k:
        if end < n:
            end += 1
        else:
            print(count)
            break
    elif tmp > k:
        start += 1
n = int(input())
arr = list(map(int, input().split()))
arr.sort()

# 만들 수 있는 최소값
cnt = 0

for i in arr:
    if i <= cnt + 1:
        cnt += i
    else:
        break


print(cnt+1)
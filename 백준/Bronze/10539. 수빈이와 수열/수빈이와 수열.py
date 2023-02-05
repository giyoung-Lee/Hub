n = int(input())
arr = list(map(int, input().split()))
tmp = [arr[0]]

for i in range(1, n):
    tmp.append(arr[i]*(i+1) - sum(tmp))

for i in tmp:
    print(i, end=' ')
n = int(input())
arr = []
for i in range(n):
    k, j = map(int, input().split())
    arr.append(k+j)
    
for i in arr:
    print(i)
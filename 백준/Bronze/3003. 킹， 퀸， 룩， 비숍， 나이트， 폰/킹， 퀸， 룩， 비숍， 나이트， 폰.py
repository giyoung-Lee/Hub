import sys
input = sys.stdin.readline

arr = list(map(int, input().split()))
temp = [1, 1, 2, 2, 2, 8]

for i in range(len(arr)):
    print(temp[i]-arr[i], end=" ")
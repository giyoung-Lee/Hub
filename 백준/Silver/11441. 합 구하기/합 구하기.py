import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

sum_arr = [0] * (n+1)

for i in range(1, len(arr)+1):
    sum_arr[i] = sum_arr[i-1] + arr[i-1]

m = int(input())

for i in range(m):
    a, b = map(int, input().split())
    print(sum_arr[b] - sum_arr[a-1])
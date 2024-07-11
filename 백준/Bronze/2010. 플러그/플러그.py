import sys
input = sys.stdin.readline

n = int(input())
result = 0

for i in range(n):
    num = int(input())
    if i == n-1:
        result += num
    else:
        result += num-1

print(result)
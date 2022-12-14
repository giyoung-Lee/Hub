import sys
input = sys.stdin.readline


def digit_sum(str):
    result = 0
    for x in str:
        if x.isdigit():
            result += int(x)

    return result


n = int(input())
arr = []

for i in range(n):
    arr.append(input().strip())

arr.sort(key=lambda x: (len(x), digit_sum(x), x))

for i in arr:
    print(i)
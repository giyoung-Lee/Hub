import sys
input = sys.stdin.readline

n = int(input())

for i in range(n):
    text = list(map(str, input()))
    text[0] = text[0].upper()

    temp = ""

    for j in text[:-1]:
        temp += j

    print(temp)
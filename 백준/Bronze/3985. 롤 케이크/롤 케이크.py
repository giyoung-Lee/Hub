l = int(input())
n = int(input())

arr = [0] * l
answer1 = 0
answer2 = 0
rook_max = 0
real_max = 0

for _ in range(n):
    a, b = map(int, input().split())

    if b-a > rook_max:
        rook_max = b-a
        answer1 = _ + 1

    temp = 0

    for i in range(a, b+1):
        if arr[i-1] == 0:
            arr[i-1] = _ + 1
            temp += 1

    if temp > real_max:
        real_max = temp
        answer2 = _ + 1

print(answer1)
print(answer2)
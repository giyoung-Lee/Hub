n = int(input())
tmp = input()
arr = []

for i in tmp:
    arr.append(i)

bonus = 0
result = 0


for i in range(n):
    if arr[i] == 'X':
        bonus = 0
    elif arr[i] == 'O':
        result += i+1 + bonus
        bonus += 1

print(result)
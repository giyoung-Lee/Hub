st = input()

n = int(input())
count = 0
for i in range(n):
    temp = input()

    if temp == st:
        count += 1

print(count)